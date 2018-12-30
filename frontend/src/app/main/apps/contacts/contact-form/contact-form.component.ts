import { Component, Inject, ViewEncapsulation } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material';

import { Contact } from 'app/main/apps/contacts/contact.model';

@Component({
    selector     : 'contacts-contact-form-dialog',
    templateUrl  : './contact-form.component.html',
    styleUrls    : ['./contact-form.component.scss'],
    encapsulation: ViewEncapsulation.None
})

export class ContactsContactFormDialogComponent
{
    action: string;
    contact: Contact;
    contactForm: FormGroup;
    dialogTitle: string;

    /**
     * Constructor
     *
     * @param {MatDialogRef<ContactsContactFormDialogComponent>} matDialogRef
     * @param _data
     * @param {FormBuilder} _formBuilder
     */
    constructor(
        public matDialogRef: MatDialogRef<ContactsContactFormDialogComponent>,
        @Inject(MAT_DIALOG_DATA) private _data: any,
        private _formBuilder: FormBuilder
    )
    {
        // Set the defaults
        this.action = _data.action;

        if ( this.action === 'edit' )
        {
            this.dialogTitle = 'Edit Contact';
            this.contact = _data.contact;
        }
        else
        {
            this.dialogTitle = 'New Contact';
            this.contact = new Contact({});
        }

        this.contactForm = this.createContactForm();
    }

    // -----------------------------------------------------------------------------------------------------
    // @ Public methods
    // -----------------------------------------------------------------------------------------------------

    /**
     * Create contact form
     *
     * @returns {FormGroup}
     */
    createContactForm(): FormGroup
    {
        return this._formBuilder.group({

            userID: [this.contact.userID],
            username: [this.contact.username],
            name: [this.contact.name],
            pics: [this.contact.pics],
            avatar: [this.contact.pics.length===0 ? 'assets/images/avatars/profile.jpg' : this.contact.pics.
                filter(_pic => {return _pic['pictureKind'] == 'avatar'}).map(_pic => {return _pic['url']})],
            gender: [this.contact.gender],
            roles: [this.contact.roles],
            rolesList: [this.contact.roles.length===0 ? '' : this.contact.roles.map(_role => {return _role['roleName']}).toString()],
            lifecycle: [this.contact.lifecycle],
            memberSince: [{value: this.contact.memberSince, disabled: true}],
            lastActive: [{value: this.contact.lastActive, disabled: true}],
            heading: [this.contact.heading],
            birthDate: [this.contact.birthDate],
            lifestyle: [this.contact.lifestyle],
            netWorth: [this.contact.netWorth],
            annualIncome: [this.contact.annualIncome],
            height: [this.contact.height],
            bodyType: [this.contact.bodyType],
            ethnicity: [this.contact.ethnicity],
            hairColor: [this.contact.hairColor],
            occupation: [this.contact.occupation],
            education: [this.contact.education],
            relationship: [this.contact.relationship],
            children: [this.contact.children],
            smoking: [this.contact.smoking],
            drinking: [this.contact.drinking],
            language: [this.contact.language],
            location: [this.contact.location],
            locations: [this.contact.locations],
            locationsList: [{value: this.contact.locations.length===0 ? '' : this.contact.locations.map(_loc => {return _loc['asTxt']}).toString(), disabled: true}],
            descrAboutME: [this.contact.descrAboutME],
            descrLookingFor: [this.contact.descrLookingFor],
            descrLookingForMore: [this.contact.descrLookingForMore]
        });
    }
}
