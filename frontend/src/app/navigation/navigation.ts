import { FuseNavigation } from '@fuse/types';

export const navigation: FuseNavigation[] = [
    {
        id       : 'adm_appl',
        title    : 'Admin Applications',
        translate: 'NAV.ADM_APPLICATIONS',
        type     : 'group',
        icon     : 'apps',
        children : [
            {
                id       : 'mail',
                title    : 'Mail',
                translate: 'NAV.MAIL.TITLE',
                type     : 'item',
                icon     : 'email',
                url      : '/apps/mail',
                badge    : {
                    title    : '25',
                    bg       : '#F44336',
                    fg       : '#FFFFFF'
                }
            },
            {
                id       : 'chat',
                title    : 'Chat',
                translate: 'NAV.CHAT',
                type     : 'item',
                icon     : 'chat',
                url      : '/apps/chat',
                badge    : {
                    title: '15',
                    bg   : '#09d261',
                    fg   : '#FFFFFF'
                }
            },
            {
                id       : 'favourites',
                title    : 'Favourites',
                translate: 'NAV.FAV',
                type     : 'item',
                icon     : 'favorite',
                url      : '/apps/favourites',
                badge    : {
                    title: '11',
                    bg   : '#09d261',
                    fg   : '#FFFFFF'
                }
            },
            {
                id       : 'file-manager',
                title    : 'File Manager',
                translate: 'NAV.FILE_MANAGER',
                type     : 'item',
                icon     : 'folder',
                url      : '/apps/file-manager'
            },
            {
                id       : 'users',
                title    : 'Users',
                translate: 'NAV.USERS',
                type     : 'item',
                icon     : 'account_box',
                url      : '/apps/contacts'
            },
            {
                id      : 'search',
                title   : 'Search',
                translate: 'NAV.SEARCH',
                type    : 'item',
                icon    : 'search',
                url  : '/apps/search'
            },
        ]
    },
    {
        id      : 'pages',
        title   : 'Usables',
        type    : 'group',
        icon    : 'pages',
        children: [
            {
                id      : 'authentication',
                title   : 'Authentication',
                type    : 'collapsable',
                icon    : 'lock',
                badge   : {
                    title: '10',
                    bg   : '#525e8a',
                    fg   : '#FFFFFF'
                },
                children: [
                    {
                        id   : 'login',
                        title: 'Login',
                        type : 'item',
                        url  : '/pages/auth/login'
                    },
                    {
                        id   : 'register',
                        title: 'Register',
                        type : 'item',
                        url  : '/pages/auth/register'
                    },
                    {
                        id   : 'forgot-password',
                        title: 'Forgot Password',
                        type : 'item',
                        url  : '/pages/auth/forgot-password'
                    },
                    {
                        id   : 'reset-password',
                        title: 'Reset Password',
                        type : 'item',
                        url  : '/pages/auth/reset-password'
                    },
                    {
                        id   : 'lock-screen',
                        title: 'Lock Screen',
                        type : 'item',
                        url  : '/pages/auth/lock'
                    },
                    {
                        id   : 'mail-confirmation',
                        title: 'Mail Confirmation',
                        type : 'item',
                        url  : '/pages/auth/mail-confirm'
                    }
                ]
            },
            {
                id   : 'coming-soon',
                title: 'Coming Soon',
                type : 'item',
                icon : 'alarm',
                url  : '/pages/coming-soon'
            },
            {
                id      : 'errors',
                title   : 'Errors',
                type    : 'collapsable',
                icon    : 'error',
                children: [
                    {
                        id   : '404',
                        title: '404',
                        type : 'item',
                        url  : '/pages/errors/error-404'
                    },
                    {
                        id   : '500',
                        title: '500',
                        type : 'item',
                        url  : '/pages/errors/error-500'
                    }
                ]
            },
            {
                id   : 'profile',
                title: 'Profile',
                type : 'item',
                icon : 'person',
                url  : '/pages/profile'
            },
            {
                id   : 'faq',
                title: 'Faq',
                type : 'item',
                icon : 'help',
                url  : '/pages/faq'
            },
        ]
    }
];
