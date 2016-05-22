package com.yazlab.balon;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;
import com.sun.javafx.iio.ImageLoader;

import java.sql.Time;
import java.util.Iterator;

public class yazlab implements ApplicationListener {

	private OrthographicCamera kmr;

	//kamera
	private SpriteBatch btc;//tuval
	private Texture balon,balons,buton,hakbuton,bilgi,cik,duz,duz1,duz2,duz3,duzzz1,sonsekil,sonsekil2;
	private Texture yeni,kirmizi;//Resimler
	private Array<Rectangle> balonlar;//Balonları tutacak diktörtgenler
	private Array<Rectangle> balonlars;
	private Array<Rectangle> balonlarsiyah;
	private int skorr=0,krmz=0,sr=0,ysl=0,syh=0,skr2,skr3;
    int basladimi=0;
	int son_skor=0;
	int hak=0;
	int kntrls=0;
	int bitti=0,bitti1=0;
	int kntrlk=0;
	long zaman=0,zamann=0,zamannn=0;
	long zaman1=0,zaman2=0,zaman3;
	int cikma=0;
	int level=1;
	int skr1=0;



    private BitmapFont fontt;
	public Texture fonttexture;
	private long sonbalon,sonbalons,sonbalonsiyah,donusum;
	Rectangle balonss,baslabuton,hakbutton,cikbutton,balonkirmizi,duzz,duz11,duzz2,duzz3,duzzzz1,rectson,rectson2;
    private Sound ses;
	@Override
	public void create() {
       // Oyun oluşturulurken çalışacak olan metoddur
		kmr= new OrthographicCamera();
		kmr.setToOrtho(false,800,480);
        fontt=new BitmapFont(Gdx.files.internal("font.fnt"));
		fonttexture=new Texture("font.png");
        hakbuton=new Texture("hakkinda.png");
		duz=new Texture("duz.png");
		balon= new Texture("yesil.png");
		buton=new Texture("buton.png");
		bilgi=new Texture("bilgi.png");
		cik=new Texture("x.png");
		yeni=new Texture("babaa.png");
		kirmizi=new Texture("balon.png");
		duz1=new Texture("duzzz.png");
		duzzz1=new Texture("duzzz1.png");
		duz2=new Texture("sekil1.png");
		duz3=new Texture("sekil2.png");
		sonsekil=new Texture("duzzz.png");
		sonsekil2=new Texture("sekil1.png");



		balons= new Texture("balons.png");// Resimler ve değişkenler tanımlanıyor
		balonlar=new Array<Rectangle>();
		balonlars=new Array<Rectangle>();
		balonlarsiyah=new Array<Rectangle>();
		balonss=new Rectangle();
		baslabuton=new Rectangle();
		hakbutton = new Rectangle();
		cikbutton=new Rectangle();
		balonkirmizi=new Rectangle();
        long son1;
		duzz=new Rectangle();
		duz11=new Rectangle();
		duz11=new Rectangle();
		duzz3=new Rectangle();
		duzz2=new Rectangle();
		duzzzz1=new Rectangle();
		rectson=new Rectangle();
		rectson2=new Rectangle();
		ses = Gdx.audio.newSound(Gdx.files.internal("ses.mp3"));



		btc=new SpriteBatch();
		balonyap();
		balonsyap();
		baslabuton();
        baslahakbuton();
		baslacikbuton();
		balonsiyahyap();
		balonkirmiziyap();
		duzyap();
		duzyapp();
		duzyap1();
		duzyap2();


	}



	///////////////////////////////////yukarı doğru olan
	private void balonyap(){
    Rectangle bln=new Rectangle();
	Rectangle blns=new Rectangle();

	bln.width=64;
	bln.height=64;
	bln.x= MathUtils.random(0,800-64);
	bln.y=0;

	balonlar.add(bln);
	sonbalon= TimeUtils.nanoTime();// Son topun zamanı tutuluyor
	}

	private void balonsiyahyap(){
		Rectangle bln=new Rectangle();
		Rectangle blns=new Rectangle();

		bln.width=64;
		bln.height=64;
		bln.x= MathUtils.random(0,800-64);
		bln.y=0;
		balonlarsiyah.add(bln);
		sonbalonsiyah= TimeUtils.nanoTime();// Son topun zamanı tutuluyor
	}


	/////////////////////////////////// Rastgele Yer Değiştiren toplar
	private void balonsyap(){


		balonss.width=64;
		balonss.height=64;
		balonss.x= MathUtils.random(0,800-64);// random yerlere atılıyor
		balonss.y=MathUtils.random(0,480-64);



	}
	private void duzyap(){


		duzz.width=129;
		duzz.height=64;
		duzz.x=100;
		duzz.y=300;
	}
	private void duzyap1(){


		duzz2.width=55;
		duzz2.height=55;
		duzz2.x=100;
		duzz2.y=300;
	}
	private void duzyap2(){


		duzz3.width=55;
		duzz3.height=55;
		duzz3.x=300;
		duzz3.y=300;
	}
    private void duzyapp(){


		duz11.width=200;
		duz11.height=64;
		duz11.x=600;
		duz11.y=300;
	}
	private void son(){


		rectson.width=200;
		rectson.height=64;
		rectson.x=600;
		rectson.y=355;
	}
	private void son1(){


		rectson2.width=200;
		rectson2.height=64;
		rectson2.x=600;
		rectson2.y=300;
	}

	private void balonkirmiziyap(){


		balonkirmizi.width=64;
		balonkirmizi.height=64;
		balonkirmizi.x= 450;// random yerlere atılıyor
		balonkirmizi.y=0;



	}
	private void baslabuton(){


		baslabuton.width=128;
		baslabuton.height=128;
		baslabuton.x=300;
		baslabuton.y=200;



	}
	private void baslahakbuton(){


		hakbutton.width=128;
		hakbutton.height=128;
		hakbutton.x=450;
		hakbutton.y=200;



	}
	private void baslacikbuton(){


		cikbutton.width=128;
		cikbutton.height=128;
		cikbutton.x=150;
		cikbutton.y=200;



	}
	private void skor(String a)
	{
        if(a=="yesil"){skorr=skorr+5;ysl=1;}
		if(a=="sari"){skorr=skorr+20;sr=1;}
		if(a=="kirmizi"){skorr=skorr+10;krmz=1;}
		if(a=="siyah"){skorr=skorr-5;syh=1;}


	}
	@Override
	public void render() {
		// oyun çalıştıgı muddetçe çalışır
		Gdx.gl.glClearColor(0, 0.1f, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);// Buffer yenileniyor

		kmr.update();// Kamera güncellenıyor
		btc.setProjectionMatrix(kmr.combined);
		btc.begin();
		// Tuval başlatılıyor
		if (basladimi == 0) {
			level=1;
			btc.draw(buton,300,200);
			btc.draw(hakbuton,450,200);
			btc.draw(cik,150,200);
			if(hak==1)
			{
				if((TimeUtils.millis()-zaman)<5000)
				{
					btc.draw(bilgi,20,10);
				}
			}
				if(cikma==1)
				{
					System.exit(0);
				}
			}
         else if(basladimi==2)
		{if((TimeUtils.millis()-zamannn)<5000) {
			if(son_skor>=300&&bitti==1)
			fontt.draw(btc, " Tebrikler !!! " + String.valueOf(son_skor) + "Puan İle oyunu Basari ile sonlandirdiniz", 20, 300);
			else fontt.draw(btc, "Maalesef Son oyunda Yapamadiniz !!! " + String.valueOf(son_skor) + "Puan İle sonlandirdiniz", 20, 300);
		}
		else{zamannn=0;son_skor=0;bitti=0; basladimi=0;}

		}
		else if(basladimi==3) {
			if ((TimeUtils.millis() - zaman1) < 5000) {
					fontt.draw(btc, "Maalesef 1 Lvlde Yapamadiniz !!! " + String.valueOf(skr1) + "Puan İle sonlandirdiniz", 20, 300);
			} else {
				zaman1 = 0;
				skr1= 0;
				bitti1 = 0;
				basladimi = 0;
			}
		}
		else if(basladimi==4) {
			if ((TimeUtils.millis() - zaman2) < 5000) {
				fontt.draw(btc, "Maalesef 2 Lvlde Yapamadiniz !!! " + String.valueOf(son_skor) + "Puan İle oyunu sonlandirdiniz", 20, 300);

			} else {
				zaman2 = 0;
				son_skor=0;
				skr2= 0;
				bitti1 = 0;
				basladimi = 0;
			}
		}


		else {if(zamannn==0)zamannn=TimeUtils.millis();
			for (Rectangle bln : balonlar) {
				btc.draw(balon, bln.x, bln.y);
			// Yukarı doğru gıdecek toplar çağırılıyor
			}
			for (Rectangle bln : balonlarsiyah) {
				btc.draw(yeni, bln.x, bln.y);// Yukarı doğru gıdecek toplar çağırılıyor
			}

			if(level==1||level==2||level==3)
			{
				if(level==1){
					btc.draw(duz,duzz.x,duzz.y);
				    btc.draw(duz1,duz11.x,duz11.y);
				}
				if(level==2){
					btc.draw(duz2,duzz2.x,duzz2.y);
					btc.draw(duz3,duzz3.x,duzz3.y);
					btc.draw(duz,duzz.x,duzz.y);
					btc.draw(duz1,duz11.x,duz11.y);
				}

				balonkirmizi.y =balonkirmizi.y+ 50 * Gdx.graphics.getDeltaTime();
				balonkirmizi.x =balonkirmizi.x+300* Gdx.graphics.getDeltaTime()*MathUtils.random(-5,+5);
				if((((TimeUtils.millis()-zamannn)/1000)%30==15)||(((TimeUtils.millis()-zamannn)/1000)%30==16))
			    btc.draw(balons, balonss.x, balonss.y);
				btc.draw(kirmizi,balonkirmizi.x, balonkirmizi.y);

			}

			////  Sarı topun x ve y si değişiyor
			fontt.draw(btc, String.valueOf(skorr)+"p", 50, 50);
			fontt.draw(btc, "   "+String.valueOf(((TimeUtils.millis()-zamannn)/1000)%30)+"sn", 90, 50);}

			fontt.draw(btc, "   "+String.valueOf(level)+" lvl ", 150, 50);
		//Tuval Kapatılıyor
		btc.end();

		if (Gdx.input.justTouched() && basladimi == 0) {//Ekrana dokunulduys
			Vector3 vektorr = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);//Dokunulan yerin koordinatları atanıyor
			kmr.unproject(vektorr);//Koordinatlara göre kamera ayarlanıyor
			Rectangle dknn = new Rectangle(vektorr.x - 16, vektorr.y - 16, 32, 32);//Parmak ucunun koordinatları diktörtgene atanıyor
			if (dknn.overlaps(baslabuton)) {

				basladimi = 1;
			}
			if (dknn.overlaps(hakbutton)) {
				zaman=TimeUtils.millis();

				hak=1;
			}
			if (dknn.overlaps(cikbutton)) {
				zamann=TimeUtils.millis();
				cikma=1;
			}

		}
		else {
			if (level == 1) {

				if (TimeUtils.nanoTime() - sonbalon > 1000000000) {//Her 1 saniyede balonu yarat fonksiyonu çağır
				duzyap();
				duzyapp();
				if((((TimeUtils.millis()-zamannn)/1000)%30)==29)
				{
					if(ysl==1&&krmz==1&&sr==1&&syh==1&&skorr>=100)
					{
						skr1=skorr;


						son_skor=son_skor+skorr;
						skorr=0;
						ysl=0;
						krmz=0;
						sr=0;
						syh=0;
						level=2;
						kntrls=0;
						balonkirmizi.x= 450;// random yerlere atılıyor
						balonkirmizi.y=0;

					}
					else {
						skr1=skorr;
						skorr=0;
						ysl=0;
						krmz=0;
						sr=0;
						syh=0;
						zamannn=0;
						zaman1=TimeUtils.millis();
						kntrls=0;
						son_skor=0;
						balonkirmizi.x= 450;// random yerlere atılıyor
						balonkirmizi.y=0;
						basladimi=3;}
				}
				balonyap();
					if(((TimeUtils.millis()-zamannn)/1000)%30==15)
					balonsyap();
			}
			if (TimeUtils.nanoTime() - sonbalonsiyah > 500000000) {//Her 1 saniyede balonu yarat fonksiyonu çağır

				balonsiyahyap();

			}

			Iterator<Rectangle> baloon = balonlar.iterator();// Balon hareket ettirmek için iterasyon gerekli
			Iterator<Rectangle> baloonsiyah = balonlarsiyah.iterator();

			int degis;
//////////////Yeşiiiiiiiiiiiiiiiiiiiiiiiiiiiil
			while (baloon.hasNext()) {// diğer balon varsa
				Rectangle baln = baloon.next();//diktörtgen tanımlanıyor
				baln.y += 200 * Gdx.graphics.getDeltaTime();// hız belirlenerek gideceği yönde pürüzsüz gözüküyor

				if (Gdx.input.justTouched()) {//Ekrana dokunulduysa
					Vector3 vektor = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);//Dokunulan yerin koordinatları atanıyor
					kmr.unproject(vektor);//Koordinatlara göre kamera ayarlanıyor
					Rectangle dkn = new Rectangle(vektor.x - 16, vektor.y - 16, 32, 32);//Parmak ucunun koordinatları diktörtgene atanıyor
					if (dkn.overlaps(baln)) {
						skor("yesil");
						ses.play();// Eğer parmak ucuyla eşleşen herhangi bir hareket eden balon varsa
						baloon.remove();//o balon yok ediliyor
					}
					if (dkn.overlaps(balonss)) {
						skor("sari");
						ses.play();
						balonss.x = 10000;
						kntrls = 1;
					}
					if (dkn.overlaps(balonkirmizi)) {
						skor("kirmizi");
						ses.play();
						balonkirmizi.x = 10000;
						kntrlk = 1;
					}

					if (baln.y + 64 > 800) {//Eğer ekranın dışına cıkan bir top varsa
						baloon.remove();//Topu yok et
					}
				}
				if(baln.overlaps(duzz))baloon.remove();
				if(baln.overlaps(duz11))baloon.remove();
			}
			////Siyahhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh
			while (baloonsiyah.hasNext()) {// diğer balon varsa
				Rectangle baln = baloonsiyah.next();//diktörtgen tanımlanıyor
				baln.y += 200 * Gdx.graphics.getDeltaTime();// hız belirlenerek gideceği yönde pürüzsüz gözüküyor
				//if(duz11.overlaps(baln))baloonsiyah.remove();
				//if(duzz.overlaps(baln))baloonsiyah.remove();
				if (Gdx.input.justTouched()) {//Ekrana dokunulduysa
					Vector3 vektor = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);//Dokunulan yerin koordinatları atanıyor
					kmr.unproject(vektor);//Koordinatlara göre kamera ayarlanıyor
					Rectangle dkn = new Rectangle(vektor.x - 16, vektor.y - 16, 32, 32);//Parmak ucunun koordinatları diktörtgene atanıyor
					if (dkn.overlaps(baln)) {
						skor("siyah");
						ses.play();// Eğer parmak ucuyla eşleşen herhangi bir hareket eden balon varsa
						baloonsiyah.remove();//o balon yok ediliyor
					}
					if (dkn.overlaps(balonss)) {
						skor("sari");
						ses.play();
						balonss.x = 10000;
						kntrls = 1;
					}
					if (dkn.overlaps(balonkirmizi)) {
						skor("kirmizi");
						ses.play();
						balonkirmizi.x = 10000;
						kntrlk = 1;

					}

					if (baln.y + 64 > 800) {//Eğer ekranın dışına cıkan bir top varsa
						baloonsiyah.remove();//Topu yok et
					}
				}
			}
	/*while (baloons!=null) {
			Rectangle baln = baloons.next();
			baln.x= MathUtils.random(0,800-64);
			baln.y=MathUtils.random(0,800-64);

		}*/
		}
			else if(level==2)
			{

				if (TimeUtils.nanoTime() - sonbalon > 1000000000) {//Her 1 saniyede balonu yarat fonksiyonu çağır

					duzyap2();
					duzyap();
					duzyapp();
					if((((TimeUtils.millis()-zamannn)/1000)%30)==29)
					{
						if(ysl==1&&krmz==1&&sr==1&&syh==1&&skorr>=100)
						{
							son_skor=son_skor+skorr;
							skorr=0;
							ysl=0;
							krmz=0;
							sr=0;
							syh=0;
							level=3;
							kntrls=0;
							balonkirmizi.x= 450;// random yerlere atılıyor
							balonkirmizi.y=0;
							level=3;
						}
						else {
							skr2=skorr;
							skorr=0;
							ysl=0;
							krmz=0;
							sr=0;
							syh=0;zamannn=0;
							zaman2=TimeUtils.millis();
							kntrls=0;

							balonkirmizi.x= 450;// random yerlere atılıyor
							balonkirmizi.y=0;
							basladimi=4;}
					}
					balonyap();
					if (kntrls == 0)
						balonsyap();
				}
				if (TimeUtils.nanoTime() - sonbalonsiyah > 500000000) {//Her 1 saniyede balonu yarat fonksiyonu çağır

					balonsiyahyap();

				}

				Iterator<Rectangle> baloon = balonlar.iterator();// Balon hareket ettirmek için iterasyon gerekli
				Iterator<Rectangle> baloonsiyah = balonlarsiyah.iterator();

				int degis;
//////////////Yeşiiiiiiiiiiiiiiiiiiiiiiiiiiiil
				while (baloon.hasNext()) {// diğer balon varsa
					Rectangle baln = baloon.next();//diktörtgen tanımlanıyor
					baln.y += 200 * Gdx.graphics.getDeltaTime();// hız belirlenerek gideceği yönde pürüzsüz gözüküyor

					if (Gdx.input.justTouched()) {//Ekrana dokunulduysa
						Vector3 vektor = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);//Dokunulan yerin koordinatları atanıyor
						kmr.unproject(vektor);//Koordinatlara göre kamera ayarlanıyor
						Rectangle dkn = new Rectangle(vektor.x - 16, vektor.y - 16, 32, 32);//Parmak ucunun koordinatları diktörtgene atanıyor
						if (dkn.overlaps(baln)) {
							skor("yesil");
							ses.play();// Eğer parmak ucuyla eşleşen herhangi bir hareket eden balon varsa
							baloon.remove();//o balon yok ediliyor
						}
						if (dkn.overlaps(balonss)) {
							skor("sari");
							ses.play();
							balonss.x = 10000;
							kntrls = 1;
						}
						if (dkn.overlaps(balonkirmizi)) {
							skor("kirmizi");
							ses.play();
							balonkirmizi.x = 10000;
							kntrlk = 1;

						}

						if (baln.y + 64 > 800) {//Eğer ekranın dışına cıkan bir top varsa
							baloon.remove();//Topu yok et
						}
					}

					if(baln.overlaps(duzz3))baloon.remove();
					if(baln.overlaps(duzz))baloon.remove();
					if(baln.overlaps(duz11))baloon.remove();
				}
				////Siyahhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh
				while (baloonsiyah.hasNext()) {// diğer balon varsa
					Rectangle baln = baloonsiyah.next();//diktörtgen tanımlanıyor
					baln.y += 200 * Gdx.graphics.getDeltaTime();// hız belirlenerek gideceği yönde pürüzsüz gözüküyor
					//if(duz11.overlaps(baln))baloonsiyah.remove();
					//if(duzz.overlaps(baln))baloonsiyah.remove();
					if (Gdx.input.justTouched()) {//Ekrana dokunulduysa
						Vector3 vektor = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);//Dokunulan yerin koordinatları atanıyor
						kmr.unproject(vektor);//Koordinatlara göre kamera ayarlanıyor
						Rectangle dkn = new Rectangle(vektor.x - 16, vektor.y - 16, 32, 32);//Parmak ucunun koordinatları diktörtgene atanıyor
						if (dkn.overlaps(baln)) {
							skor("siyah");
							ses.play();// Eğer parmak ucuyla eşleşen herhangi bir hareket eden balon varsa
							baloonsiyah.remove();//o balon yok ediliyor
						}
						if (dkn.overlaps(balonss)) {
							skor("sari");
							ses.play();
							balonss.x = 10000;
							kntrls = 1;
						}
						if (dkn.overlaps(balonkirmizi)) {
							skor("kirmizi");
							ses.play();
							balonkirmizi.x = 10000;
							kntrlk = 1;
						}

						if (baln.y + 64 > 800) {//Eğer ekranın dışına cıkan bir top varsa
							baloonsiyah.remove();//Topu yok et
						}
					}
				}
	/*while (baloons!=null) {
			Rectangle baln = baloons.next();
			baln.x= MathUtils.random(0,800-64);
			baln.y=MathUtils.random(0,800-64);

		}*/
			}
			else if(level==3)
			{

				if (TimeUtils.nanoTime() - sonbalon > 1000000000) {//Her 1 saniyede balonu yarat fonksiyonu çağır
					//duzyap();
					//duzyapp();
					if((((TimeUtils.millis()-zamannn)/1000)%30)==29)
					{   if(ysl==1&&krmz==1&&sr==1&&syh==1&&skorr>=100)bitti=1;
						zamannn=TimeUtils.millis();
						son_skor=son_skor+skorr;
						skorr=0;
						ysl=0;
						krmz=0;
						sr=0;
						syh=0;
						kntrls=0;
						balonkirmizi.x= 450;// random yerlere atılıyor
						balonkirmizi.y=0;

						basladimi=2;



					}
					balonyap();
					if (kntrls == 0)
						balonsyap();
				}
				if (TimeUtils.nanoTime() - sonbalonsiyah > 500000000) {//Her 1 saniyede balonu yarat fonksiyonu çağır

					balonsiyahyap();

				}

				Iterator<Rectangle> baloon = balonlar.iterator();// Balon hareket ettirmek için iterasyon gerekli
				Iterator<Rectangle> baloonsiyah = balonlarsiyah.iterator();

				int degis;
//////////////Yeşiiiiiiiiiiiiiiiiiiiiiiiiiiiil
				while (baloon.hasNext()) {// diğer balon varsa
					Rectangle baln = baloon.next();//diktörtgen tanımlanıyor
					baln.y += 200 * Gdx.graphics.getDeltaTime();// hız belirlenerek gideceği yönde pürüzsüz gözüküyor
					//	if(baln.overlaps(duzz))baloon.remove();
					//	if(baln.overlaps(duz11))baloon.remove();
					if (Gdx.input.justTouched()) {//Ekrana dokunulduysa
						Vector3 vektor = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);//Dokunulan yerin koordinatları atanıyor
						kmr.unproject(vektor);//Koordinatlara göre kamera ayarlanıyor
						Rectangle dkn = new Rectangle(vektor.x - 16, vektor.y - 16, 32, 32);//Parmak ucunun koordinatları diktörtgene atanıyor
						if (dkn.overlaps(baln)) {
							skor("yesil");
							ses.play();// Eğer parmak ucuyla eşleşen herhangi bir hareket eden balon varsa
							baloon.remove();//o balon yok ediliyor
						}
						if (dkn.overlaps(balonss)) {
							skor("sari");
							ses.play();
							balonss.x = 10000;
							kntrls = 1;
						}
						if (dkn.overlaps(balonkirmizi)) {
							skor("kirmizi");
							ses.play();
							balonkirmizi.x = 10000;
							kntrlk = 1;

						}

						if (baln.y + 64 > 800) {//Eğer ekranın dışına cıkan bir top varsa
							baloon.remove();//Topu yok et
						}
					}
				}
				////Siyahhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh
				while (baloonsiyah.hasNext()) {// diğer balon varsa
					Rectangle baln = baloonsiyah.next();//diktörtgen tanımlanıyor
					baln.y += 200 * Gdx.graphics.getDeltaTime();// hız belirlenerek gideceği yönde pürüzsüz gözüküyor
					//if(duz11.overlaps(baln))baloonsiyah.remove();
					//if(duzz.overlaps(baln))baloonsiyah.remove();
					if (Gdx.input.justTouched()) {//Ekrana dokunulduysa
						Vector3 vektor = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);//Dokunulan yerin koordinatları atanıyor
						kmr.unproject(vektor);//Koordinatlara göre kamera ayarlanıyor
						Rectangle dkn = new Rectangle(vektor.x - 16, vektor.y - 16, 32, 32);//Parmak ucunun koordinatları diktörtgene atanıyor
						if (dkn.overlaps(baln)) {
							skor("siyah");
							ses.play();// Eğer parmak ucuyla eşleşen herhangi bir hareket eden balon varsa
							baloonsiyah.remove();//o balon yok ediliyor
						}
						if (dkn.overlaps(balonss)) {
							skor("sari");
							ses.play();
							balonss.x = 10000;
							kntrls = 1;
						}
						if (dkn.overlaps(balonkirmizi)) {
							skor("kirmizi");
							ses.play();
							balonkirmizi.x = 10000;
							kntrlk = 1;
						}

						if (baln.y + 64 > 800) {//Eğer ekranın dışına cıkan bir top varsa
							baloonsiyah.remove();//Topu yok et
						}
					}
				}
	/*while (baloons!=null) {
			Rectangle baln = baloons.next();
			baln.x= MathUtils.random(0,800-64);
			baln.y=MathUtils.random(0,800-64);

		}*/
			}

		}
	}

	public void dispose() {
// oyun kapatıldıgında yada durakladıgında , ses resim müzikleri bellekten silmeye yarar
	}


	@Override
	public void resize(int width, int height) {

	}

	@Override
	public void pause() {

	}

	@Override
	public void resume() {

	}


}
