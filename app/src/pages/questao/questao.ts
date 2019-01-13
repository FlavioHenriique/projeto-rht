import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import { Questao } from '../../model/Questao';
import { HttpClient } from '@angular/common/http';

@IonicPage()
@Component({
  selector: 'page-questao',
  templateUrl: 'questao.html',
})
export class QuestaoPage {

  private questoes: any = {};
  private questao: Questao = {};
  private posicao: number;
  private url: string = "http://localhost:8085/questoes/";

  constructor(public navCtrl: NavController, public navParams: NavParams, public http: HttpClient) {
    this.posicao = navParams.get("posicao");
    if (this.posicao == null) {
      this.buscarQuestoes();
    } else {
      this.questoes = navParams.get("questoes");
      this.questao = this.questoes[this.posicao];
      this.posicao = this.questao.posicao;
    }
  }

  buscarQuestoes() {
    this.http.get(this.url, { observe: 'response' }).subscribe(res => {
      if (res.status == 200) {
        this.questoes = res.body;
        this.questao = this.questoes[0];
        this.posicao = this.questao.posicao;
      }
    });
  }

  proximaQuestao() {
    this.navCtrl.push(QuestaoPage, { "posicao": this.questao.posicao, "questoes":this.questoes });
  }

  ehUltima(){
    return this.questoes.length == this.posicao;
  }
}
