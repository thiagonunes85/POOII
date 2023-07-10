import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Observable} from 'rxjs';
import { aluno } from './aluno.model';

@Injectable({
  providedIn: 'root'
})
export class alunoService {

  constructor(private httpClient: HttpClient,
              private _snackBar: MatSnackBar) { }

    baseUrl = 'http://localhost:8080/academico/alunos';
    
    openSnackBar(message: string) {
        this._snackBar.open(message, 'X', {
          duration:2000,
          verticalPosition:"top",
          horizontalPosition:"right"
        });
    }

    //Fiz algumas alterações depois da aula.
    //Ao invés de utilizar um valor qualquer (any) decidi colocar o tipo esperado

    //Neste caso em especial teremos um array de alunos como retorno do método getalunoList
    //Lembrando que agoar o http teve retornar um tipo definido, 
    //assim temos que incluir o tipo também no retorno do método get do HTTPCliente
    getalunoList():Observable<aluno[]>{
      return this.httpClient.get<aluno[]>(`${this.baseUrl}`);
    }

    getaluno(id: number):Observable<aluno>{
      return this.httpClient.get<aluno>(`${this.baseUrl}/${id}`);
    }

    createaluno(c: aluno):Observable<aluno>{
      return this.httpClient.post<aluno>(`${this.baseUrl}`,c);
    } 

    updatealuno(id: number, c: aluno):Observable<aluno>{
      return this.httpClient.put<aluno>(`${this.baseUrl}/${id}`, c);
    } 

    deletealuno(id: number):Observable<aluno>{
      return this.httpClient.delete<aluno>(`${this.baseUrl}/${id}`);
    } 

  }
