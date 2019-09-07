export interface Properties {
    code?: string;
    size?: string;
    color?: string;
    material?: string;
    description?: string;
    barCode?: string;
}

export interface Product {
    id?: number;
    brandName?: string;
    name?: string;
    properties?: Properties;
    note?: string;
    number?: number;
    stickerPrice?: number;
    importedPrice?: number;
    importAmount?: number;
    created?: number;
    updated?: any;
}

export class Properties {
    constructor() {
    }
    parser(
        code?: string,
        size?: string,
        color?: string,
        material?: string,
        description?: string,
        barCode?: string) {
    }

}

export class Product {
    constructor() {
        // this.properties = new Properties();
    }
    parser(
        id?: number,
        brandName?: string,
        name?: string,
        properties?: Properties,
        note?: string,
        number?: number,
        stickerPrice?: number,
        importedPrice?: number,
        importAmount?: number,
        created?: number,
        updated?: any) {
    }
}


