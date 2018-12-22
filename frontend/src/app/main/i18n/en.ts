import {Validators} from "@angular/forms";

export const locale = {
    lang: 'en',
    data: {
        'NAV': {
            'ADM_APPLICATIONS': 'Admin Applications',
            'MAIL':{
                'TITLE': 'Mail',
            },
            'CHAT': 'Chat',
            'FAV': 'Favourites',
            'FILE_MANAGER': 'File manager',
            'USERS': 'Users',
            'SEARCH': 'Search'
        },
        'backErr': {
            'login_no_account': 'Authentication failed',
            'login_validation_err': 'Login information is invalid',
            'reg_pass_no_match': 'Passwords must match',
            'reg_validation_err': 'Registration information is invalid'
        },
        'Login': {
            'acc_login': 'LOGIN TO YOUR ACCOUNT',
            'email': 'Email',
            'email_required': 'Email is required',
            'email_pls': 'Please enter a valid email address',
            'password': 'Password',
            'password_required': 'Password is required',
            'password_length': 'Password must have min 6 chars',
            'remember_me': 'Remember me',
            'forgot_password': 'Forgot Password?',
            'login': 'LOGIN',
            'or': 'OR',
            'login_google': 'Log in with Google',
            'login_facebook': 'Log in with Facebook',
            'no_account': 'Don\'t have an account?',
            'create_account': 'Create an account'
        },
        'Register': {
            'register': 'REGISTER',
            'acc_create': 'CREATE AN ACCOUNT',
            'name': 'Name',
            'name_required': 'Name is required',
            'name_length': 'Name must have min 4 chars',
            'password_confirm': 'Password (Confirm)',
            'password_confirm_required': 'Password confirmation is required',
            'password_must_match': 'Passwords must match',
            'read_accept': 'I read and accept',
            'terms_cond': 'terms and conditions',
            'acc_allready': 'Already have an account?',
            'login': 'Login'
        }
    }
};
