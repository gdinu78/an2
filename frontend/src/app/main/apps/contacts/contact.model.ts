
export class Contact
{
    userID: string;
    username: string;
    password:string;
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
    locations: [];
    descrAboutME: string;
    descrLookingFor: string;
    descrLookingForMore: string;
    //aditional
    avatar: string;
    rolesList: string;
    locationsList: string;

    /**
     * Constructor
     *
     * @param contact
     */
    constructor(contact)
    {
        {
            this.userID = contact.userID || '';
            this.username = contact.username || '';
            this.password = contact.password || '';
            this.name = contact.name || '';
            this.pics = contact.pics || [];
            this.avatar = this.pics.length===0 ? 'assets/images/avatars/profile.jpg' : contact.pics.
            filter(_pic => {return _pic.pictureKind=='avatar'}).map(_pic => {return _pic.url});
            this.gender = contact.gender || '';
            this.roles = contact.roles || [];
            this.rolesList = this.roles.length===0 ? '' : contact.roles.map(_role => {return _role.roleName}).toString();
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
            this.locations = contact.locations || [];
            this.locationsList = this.locations.length===0 ? '' : contact.locations.map(_loc => {return _loc.asTxt}).toString();
            this.descrAboutME = contact.descrAboutME || '';
            this.descrLookingFor = contact.descrLookingFor || '';
            this.descrLookingForMore = contact.descrLookingForMore || '';

        }
    }
}
