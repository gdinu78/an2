import { Component, OnInit, ViewEncapsulation } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

import { FuseConfigService } from '@fuse/services/config.service';
import { fuseAnimations } from '@fuse/animations';
import {BackendService} from "../../../../_services";
import {ServRespModel, User} from "../../../../_models";
import {ActivatedRoute, Router} from "@angular/router";
import {FuseTranslationLoaderService} from "../../../../../@fuse/services/translation-loader.service";
import { locale as english } from '../../../i18n/en';
import { locale as turkish } from '../../../i18n/tr';
import { locale as romanian } from '../../../i18n/ro';

@Component({
    selector     : 'login',
    templateUrl  : './login.component.html',
    styleUrls    : ['./login.component.scss'],
    encapsulation: ViewEncapsulation.None,
    animations   : fuseAnimations
})
export class LoginComponent implements OnInit
{
    loginForm: FormGroup;
    user: User;
    loading = false;
    submitted = false;
    returnUrl: string;
    backendError;

    /**
     * Constructor
     *
     * @param {FuseConfigService} _fuseConfigService
     * @param {FormBuilder} _formBuilder
     */
    constructor(
        private _fuseTranslationLoaderService: FuseTranslationLoaderService,
        private _fuseConfigService: FuseConfigService,
        private _formBuilder: FormBuilder,
        private backendService: BackendService,
        private route: ActivatedRoute,
        private router: Router
    )
    {
        // Configure the layout
        this._fuseConfigService.config = {
            layout: {
                navbar   : {
                    hidden: true
                },
                toolbar  : {
                    hidden: false
                },
                footer   : {
                    hidden: true
                },
                sidepanel: {
                    hidden: true
                }
            }
        };
        this._fuseTranslationLoaderService.loadTranslations(english, turkish, romanian);
    }

    // -----------------------------------------------------------------------------------------------------
    // @ Lifecycle hooks
    // -----------------------------------------------------------------------------------------------------

    /**
     * On init
     */
    ngOnInit(): void
    {
        this.loginForm = this._formBuilder.group({
            email   : ['', [Validators.required, Validators.email]],
            password: ['', [Validators.required, Validators.minLength(6)]]
        });

        // reset login status
        sessionStorage.removeItem('currentUser');

        // get return url from route parameters or default to '/'
        this.returnUrl = this.route.snapshot.queryParams['returnUrl'] || '/';
    }

    onSubmit():void{
        // stop here if form is invalid
        if (this.loginForm.invalid) {
            return;
        }
        this.submitted = true;
        this.loading = true;
        this.user = {
            username: this.loginForm.get('email').value,
            password: this.loginForm.get('password').value,
            passwordConfirm: this.loginForm.get('password').value,
            name: this.loginForm.get('email').value,
            agreedTerms: true,
            gender: 0
        };
        this.backendService.postResults('/api/authenticate',this.user)
            .subscribe((res : ServRespModel) => {
                if (res.message != 'ERROR') {
                   sessionStorage.setItem('currentUser', res.results);
                   this.router.navigate(['/sample']);
                }else{
                    this.backendError=res.results;
                }
            },
                error => {
                    this.loading = false;
                });
    }
}
