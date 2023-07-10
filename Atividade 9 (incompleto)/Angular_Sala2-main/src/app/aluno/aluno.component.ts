import { Component, OnInit, ViewChild } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { Router } from '@angular/router';

import { alunoService } from './aluno.service';
import { aluno } from './aluno.model';

@Component({
  selector: 'app-alunos',
  templateUrl: './aluno.component.html',
  styleUrls: ['./aluno.component.css']
})
export class alunosComponent implements OnInit {

  aluno: aluno = new aluno();

  alunoDataSource: MatTableDataSource<aluno> = new MatTableDataSource();

  displayedalunos: String[] = ['idaluno', 'nomealuno', 'update', 'delete'];

  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;

  constructor(private alunoService: alunoService, private router: Router) { }

  ngOnInit(): void {
    this.getalunoList();
  }

  getalunoList() {

    //Na real, não sei porque o VS está achando que o subscribe está depreciado
    //Vou explicar aqui pra que serve o método "subscribe". 
    //Como o próprio nome já diz, estou me inscrevendo no método getalunoList do alunoService
    //Isto significa que sempre que houver uma alteração no conteúdo do Observable retornado getalunoList, os "dados" serão atualizados
    //na nossa Tabela (MatTableDataSource)
    this.alunoService.getalunoList().subscribe(
        dados => {
          this.alunoDataSource = new MatTableDataSource<aluno>(dados as aluno[]);
          this.alunoDataSource.paginator = this.paginator;
          this.alunoDataSource.sort = this.sort;
        },
        error => console.log(error)
      );
  }

  filtraralunos(event: Event) {
    let valor = (event.target as HTMLInputElement).value;
    this.alunoDataSource.filter = valor;
  }

  deletaraluno(delaluno : aluno){
    this.alunoService.deletealuno(delaluno.idaluno).subscribe(
      dados => {
        this.alunoService.openSnackBar('aluno excluído !');
        this.getalunoList();
      }
    )
  }
  
  navigateToalunoNovo() {
    this.router.navigate(['/aluno-novo']);
  }

  navigateToalunoEditar(aluno: aluno) {
    this.router.navigate([`/aluno-editar/${aluno.idaluno}`]);
  }

}