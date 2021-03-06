import { BrowserModule } from '@angular/platform-browser';
import { ErrorHandler, NgModule } from '@angular/core';
import { IonicApp, IonicErrorHandler, IonicModule } from 'ionic-angular';
import { SplashScreen } from '@ionic-native/splash-screen';
import { StatusBar } from '@ionic-native/status-bar';
import { HttpClientModule } from '@angular/common/http';

import { MyApp } from './app.component';
import { HomePage } from '../pages/home/home';
import { SobrePageModule } from '../pages/sobre/sobre.module';
import { CadastroPageModule } from '../pages/cadastro/cadastro.module';
import { QuestaoPageModule } from '../pages/questao/questao.module';
import { GraficoPageModule } from '../pages/grafico/grafico.module';
import * as HighCharts from 'highcharts';
import * as HighchartsMore from 'highcharts/highcharts-more';



@NgModule({
  declarations: [
    MyApp,
    HomePage
  ],
  imports: [
    BrowserModule,
    IonicModule.forRoot(MyApp),
    SobrePageModule,
    HttpClientModule,
    CadastroPageModule,
    QuestaoPageModule,
    GraficoPageModule
  ],
  bootstrap: [IonicApp],
  entryComponents: [
    MyApp,
    HomePage
  ],
  providers: [
    StatusBar,
    SplashScreen,
    {provide: ErrorHandler, useClass: IonicErrorHandler}
  ]
})
export class AppModule {}
