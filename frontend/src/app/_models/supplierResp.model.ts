import {SupplierModel} from "./supplier.model";

export interface SupplierRespModel {
    count:number;
    results: SupplierModel[];
}
