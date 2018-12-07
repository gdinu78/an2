
export interface SupplierModel {
    type: string;
    name: string;
    lifecycle: string;
    place: object;
    phoneNumber: string;
    email: string;
    minPrice: number;
    minInv: number;
    maxInv: number;
    outdoor: boolean;
    accommodation: boolean;
    fireworks: boolean;
    events: boolean;
    preparations: boolean;
    parking: boolean;
    password: string;
}
