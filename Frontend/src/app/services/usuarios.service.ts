import { Usuario } from './../models/Usuario';
import { HttpClient } from '@angular/common/http'
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UsuariosService
{
  private URL_API = "http://localhost:8080/usuario"

  constructor(private http: HttpClient) { }

  save(usuario: Usuario)
  {
    return this.http.post<String>(this.URL_API, usuario)    
  }

  get()
  {
    return this.http.get<Usuario[]>(this.URL_API)
  }
}
