import { Product } from './product';

export interface BillDetail {
    selectedProduct: Product;
    sellNumber?;
    discount?;
    amountPrice?;
    note?;
    payment?;
    paymentNote?;
    biller?;
    createdDate?;
}

export class BillDetailSample implements BillDetail {
    constructor(
        public selectedProduct: Product,
        public sellNumber?,
        public discount?,
        public amountPrice?,
        public note?,
        public payment?,
        public paymentNote?,
        public biller?,
        public createdDate?) { }
}
