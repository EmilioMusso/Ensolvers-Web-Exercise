import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, NgForm, Validators } from '@angular/forms';
import { Item } from './item';
import { ItemService } from './item.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  public items: Item[] = [];
  public editItem: Item | undefined;
  public deleteItem: Item | undefined;
  public addItemForm: FormGroup;

  constructor(private itemService: ItemService, private fb: FormBuilder) {
    this.addItemForm = fb.group({
      name: ['', Validators.required]
    })
  }

  ngOnInit() {
    this.getItems();
  }

  public getItems(): void {
    this.itemService.getItems().subscribe(
      (response: Item[]) => {
        this.items = response;
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }



  public onAddItem(item: Item): void {
      console.log("Add", item);
  }

  public onUpdateItem(item: Item): void {
      console.log("Update", item);
  }

  public onDeleteItem(itemId: number): void {
    console.log("Delete", itemId);
  }
  


}
