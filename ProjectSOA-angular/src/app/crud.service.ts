import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CrudService {

  readonly path = "http://localhost:8080";

  constructor(private http: HttpClient) { }
  getProductList(): Observable<any[]> {
    return this.http.get<any>(this.path + '/product');
  }
  addProduct(data: any) {
    return this.http.post(this.path + '/product', data);
  }
  updateProduct(id: number | string, data: any) {
    return this.http.put(this.path + `/product/${id}`, data)
  }
  deleteProduct(id: number | string) {
    return this.http.delete(this.path + `/product/${id}`)
  }
  consulterProduit(id: number | string):Observable<any> {
    return this.http.get<any>(this.path + `/product/${id}`);
  }
}
