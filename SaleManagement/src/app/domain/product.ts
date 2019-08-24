export interface Product {
    brand?;
    name?;
    code?;
    material?;
    description?;
    color?;
    size?;
    number?;
    stickerPrice?;
    importedPrice?;
    created?;
    updated?;
    note?;
    importAmount?;
}

export class ProductSample implements Product {
    constructor(
        public brand?,
        public name?,
        public code?,
        public material?,
        public description?,
        public color?,
        public size?,
        public number?,
        public stickerPrice?,
        public importedPrice?,
        public created?,
        public updated?,
        public note?,
        public importAmount?) { }
}
