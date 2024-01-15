export type Product = {
    id?: number,
    name: string,
    price: number,
    img?: File | HTMLInputElement | Blob,
	imgUrl: string,
    quantity: number
};