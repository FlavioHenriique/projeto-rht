import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import * as HighCharts from 'highcharts/highcharts';
import * as HighchartsMore from 'highcharts/highcharts-more';
import { Empresa } from '../../model/Empresa';
import { HomePage } from '../home/home';
import { HttpClient } from '@angular/common/http';
import { Grafico } from '../../model/Grafico';

HighchartsMore(HighCharts);

@IonicPage()
@Component({
  selector: 'page-grafico',
  templateUrl: 'grafico.html',
})
export class GraficoPage {
  private empresa: Empresa = null;
  private url: string = "http://localhost:8085/respostas/grafico/";
  private myChart = null;

  constructor(public navCtrl: NavController, public navParams: NavParams, public http: HttpClient) {
    this.empresa = navParams.get("empresa");
  }

  ionViewDidLeave(){
    this.myChart = null;
  }

  ionViewDidLoad() {
    let busca = this.url + this.empresa.codigo;
    
    var json;
    this.http.get(busca, { observe: 'response' }).subscribe(res => {
      if (res.status == 200) {
         this.myChart = HighCharts.chart('container', {
          chart: {
            polar: true,
            marginBottom: 70
          },

          title: {
            text: 'Situação da empresa ' + this.empresa.nome + ' em relação as estratégias de resolução de conflito'
          },

          pane: {
            size: '80%'
          },

          xAxis: {
            categories: res.body.estrategias,
            tickmarkPlacement: 'on',
            lineWidth: 0
          },

          yAxis: {
            gridLineInterpolation: 'polygon',
            lineWidth: 0,
            min: 0,
            labels: false
          },

          tooltip: {
            shared: true,
            pointFormat: '<span style="color:{series.color}">{series.name}: <b>{point.y:,.0f}</b><br/>'
          },

          series: [{
            name: 'Estratégias de resolução de conflito',
            type: 'area',
            data: res.body.dados,
            pointPlacement: 'on'
          }]

        });
      }
    });


  }


  home() {
    this.navCtrl.popToRoot();
  }
}
