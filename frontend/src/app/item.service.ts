import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Item } from './item';

@Injectable({
  providedIn: 'root'
})
export class ItemService {
  private apiServerUrl=environment.apiBaseUrl;

  constructor(private http: HttpClient) { }

  public getItems(): Observable<Item[]> {
    return this.http.get<Item[]>(`${this.apiServerUrl}/`)
  }

  public addItem(item: Item): Observable<Item> {
    return this.http.post<Item>(`${this.apiServerUrl}/add`, item);
  }

  public updateItem(item: Item): Observable<Item> {
    return this.http.put<Item>(`${this.apiServerUrl}/update`, item);
  }

  public deleteItem(itemId: number): Observable<void> {
    return this.http.delete<void>(`${this.apiServerUrl}/delete/${itemId}`);
  }
}
