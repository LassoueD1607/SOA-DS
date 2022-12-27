import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { CrudService } from '../crud.service';

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit {

  productList$!: Observable<any[]>;
  productList!: any[];
  productId=0;
  productName:string=""
  productCategory:string=""
  productQuantity:number=0
  productPrice:number=0.0
  currentProduit = {};
  id = 0;
  

 

  constructor(private service: CrudService, private activatedRoute: ActivatedRoute, private router: Router) {
    this.productList$ = this.service.getProductList();
    
    

   }

  ngOnInit(): void {
    this.productList$.forEach(data => {
      this.productList = data;
      this.trierProduits(this.productList)
    });
    
  }
    
    addNewProduct(){
      let newProduct = {
        name:this.productName,
        category:this.productCategory,
        quantity:this.productQuantity,
        price:this.productPrice
      }
      
      if (newProduct.name != "" && newProduct.category != ""  && newProduct.quantity != 0 && newProduct.price != 0.0) {
        
      this.service.addProduct(newProduct).subscribe();
      window.location.reload();
      
    
      }}
      
      onUpdateProduct(id:number){
        this.service.consulterProduit(id).subscribe((prod) => { this.currentProduit = prod;
          this.productId=prod.id;
          this.productName=prod.name;
          this.productCategory=prod.category;
          this.productQuantity=prod.quantity;
          this.productPrice=prod.price;
         }) 
      }
      confirmUpdate(){
        let updatedProduct = {
          name:this.productName,
          category:this.productCategory,
          quantity:this.productQuantity,
          price:this.productPrice
        }
        this.service.updateProduct(this.productId,updatedProduct).subscribe()
        window.location.reload();
        
      }
      onDeleteProduct(id:number){
        console.log(id)
        this.service.deleteProduct(id).subscribe()
        window.location.reload();

      }
      trierProduits(produits: any[]) {
        produits.sort((n1, n2) => {
          if (n1.id > n2.id) {
            return 1;
          }
          if (n1.id < n2.id) {
            return -1;
          }
          return 0;
        });
      }
}

