import { Injectable } from '@angular/core';
import { HttpRequest, HttpHandler, HttpEvent, HttpInterceptor } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import {BackendService} from "../_services";


@Injectable()
export class ErrorInterceptor implements HttpInterceptor {

    constructor(
        private backendService: BackendService
    ){}
    intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        return next.handle(request).pipe(catchError(err => {
            if (err.status === 401) {
                // auto logout if 401 response returned from api
                sessionStorage.removeItem('currentUser');
                location.reload(true);
            }
            const error = err.error.results || err.error.message || err.statusText;
            this.backendService.postResults('/api/clientLog',error)
                .subscribe((data =>{
                    }),
                    error => {
                        console.log('am eroarea: ', error);
                    });
            return throwError(error);
        }))
    }
}