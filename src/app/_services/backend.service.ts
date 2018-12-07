import { Injectable } from '@angular/core';
import {HttpClient, HttpErrorResponse, HttpHeaders} from '@angular/common/http'
import {Observable, throwError} from 'rxjs';
import {ServRespModel} from '../_models';
import {map} from 'rxjs/internal/operators';
import {catchError} from 'rxjs/operators';


@Injectable()
export class BackendService {

    constructor(private http: HttpClient) {}

    getResults(url: string): Observable<any> {
        url = 'http://localhost:8080' + url;
        const httpOptions = {
            headers: new HttpHeaders({'Content-Type': 'application/json'})
        };
        return this.http.get<ServRespModel>(url).pipe(map((data) => {
            if (data.rc !== 0) {
                throw(data.message);
            } else {
                return data.results;
            }
        }),
            catchError(this.handleError)
        );
    }

    postResults(url: string, data): Observable<any> {
        url = 'http://localhost:8080' + url;
        const httpOptions = {
            headers: new HttpHeaders({'Content-Type': 'application/json'})
        };
        return this.http.post<ServRespModel>(url, data, httpOptions).pipe(map(res => {
            if (res.rc !== 0) {
                throw(res.message);
            } else {
                return res.results;
            }
        }),
            catchError(this.handleError)
        );
    }

    private handleError(error: HttpErrorResponse): Observable<any>{
        if (error.error instanceof ErrorEvent) {
            // A client-side or network error occurred. Handle it accordingly.
            console.error('An error occurred:', error.error.message);
        } else {
            // The backend returned an unsuccessful response code.
            // The response body may contain clues as to what went wrong,
            console.error(
                `Backend returned code ${error.status}, ` +
                `body was: ${error.error}`);
        }
        // return an observable with a user-facing error message
        return throwError(
            'Something bad happened; please try again later.');
    }
}
