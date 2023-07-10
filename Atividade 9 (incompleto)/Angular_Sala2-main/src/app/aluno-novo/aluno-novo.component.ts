import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { aluno } from '../aluno/aluno.model';
import { alunoservice } from '../aluno/aluno.service';

@Component({
  selector: 'app-aluno-novo',
  templateUrl: './aluno-novo.component.html',
  styleUrls: ['./aluno-novo.component.css']
})

export class alunoNovoComponent implements OnInit {

  aluno: aluno = new aluno();

  constructor(private alunoervice: alunoervice,
              private router: Router) { }

  ngOnInit(): void {}
  
  salvar() {
     this.alunoervice.createaluno(this.aluno).subscribe(
      dado => {
                console.log(dado)
                this.alunoervice.openSnackBar('aluno criado com sucesso !');
                this.router.navigate(['/aluno']);
              }
    )
  }

  cancelar() {
      this.router.navigate(['/aluno']);
  }

}