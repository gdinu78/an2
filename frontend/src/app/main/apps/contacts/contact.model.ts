import { FuseUtils } from '@fuse/utils';

export class Contact
{
    // id: string; userid
    // name: string;name
    // lastName: string;
    // avatar: string;to do
    // nickname: string;noneed
    // company: string;noneed
    // jobTitle: string;noneed
    // email: string;username
    // phone: string;noneed
    // address: string;noneed
    // birthday: string;birthdate
    // notes: string;descrAboutME

    userID: string;
    username: string;
    name: string;
    gender: string;
    favourite: [];
    roles: [];
    lifecycle: string;
    memberSince: string;
    lastActive: string;
    heading: string;
    birthDate: string;
    lifestyle: string;
    netWorth: string;
    annualIncome: string;
    height: number;
    bodyType: string;
    ethnicity: string;
    hairColor: string;
    occupation: string;
    education: string;
    relationship: string;
    children: number;
    smoking: string;
    drinking: string;
    language: string;
    pics: [];
    location: string;
    descrAboutME: string;
    descrLookingFor: string;
    descrLookingForMore: string;

    /**
     * Constructor
     *
     * @param contact
     */
    constructor(contact)
    {
        {
            this.userID = contact.userID || FuseUtils.generateGUID();
            this.username = contact.userName || '';
            this.name = contact.name || '';
            this.pics = contact.pics || ['assets/images/avatars/profile.jpg'];
            this.gender = contact.gender || '';
            this.roles = contact.roles || '';
            this.lifecycle = contact.lifecycle || '';
            this.memberSince = contact.memberSince || '';
            this.lastActive = contact.lastActive || '';
            this.heading = contact.heading || '';
            this.birthDate = contact.birthDate || '';
            this.lifestyle = contact.lifestyle || '';
            this.netWorth = contact.netWorth || '';
            this.annualIncome = contact.annualIncome || '';
            this.height = contact.height || '';
            this.bodyType = contact.bodyType || '';
            this.ethnicity = contact.ethnicity || '';
            this.hairColor = contact.hairColor || '';
            this.occupation = contact.occupation || '';
            this.education = contact.education || '';
            this.relationship = contact.relationship || '';
            this.children = contact.children || '';
            this.smoking = contact.smoking || '';
            this.drinking = contact.drinking || '';
            this.language = contact.language || '';
            this.favourite = contact.favourite || [];
            this.location = contact.location || '';
            this.descrAboutME = contact.descrAboutME || '';
            this.descrLookingFor = contact.descrLookingFor || '';
            this.descrLookingForMore = contact.descrLookingForMore || '';

        }
    }
}
