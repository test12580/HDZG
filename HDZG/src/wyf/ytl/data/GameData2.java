package wyf.ytl.data;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

import wyf.ytl.R;
import wyf.ytl.R.drawable;
import wyf.ytl.entity.CityDrawable;
import wyf.ytl.entity.FishingDrawable;
import wyf.ytl.entity.ForestDrawable;
import wyf.ytl.entity.LuBanDrawable;
import wyf.ytl.entity.MaChangDrawable;
import wyf.ytl.entity.MineDrawable;
import wyf.ytl.entity.MoZiDrawable;
import wyf.ytl.entity.MyMeetableDrawable;
import wyf.ytl.entity.PalaceDrawable;
import wyf.ytl.entity.RiceDrawable;
import wyf.ytl.entity.SunZiDrawable;
import wyf.ytl.entity.TieJangPuDrawable;
import wyf.ytl.entity.TreeDrawable;
import wyf.ytl.entity.VillageDrawable;
import wyf.ytl.entity.WheatDrawable;
import wyf.ytl.entity.WuGuanDrawable;
import wyf.ytl.entity.XueTangDrawable;
import wyf.ytl.entity.YiZhanDrawable;
import wyf.ytl.entity.ZhanXianGuanDrawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class GameData2 {
	//各种MyDrawable对象在这里初始化
	public static Resources resources;
	static Bitmap forestDrawableBitmap;
	static Bitmap treeDrawableBitmap;
	static Bitmap moZiDrawableBitmap;
	static Bitmap yiZhanDrawableBitmap;
	static Bitmap fishingDrawableBitmap;
	static Bitmap cityDrawableBitmap;
	static Bitmap mineDrawableBitmap;
	static Bitmap riceDrawableBitmap;
	static Bitmap tieJangPuDrawableBitmap;
	static Bitmap bmpDialogBack;
	static Bitmap bmpDialogButton;
	static Bitmap sunZiDrawableBitmap;
	static Bitmap luBanDrawableBitmap;
	static Bitmap villageDrawableBitmap;
	static Bitmap wuGuanDrawableBitmap;
	static Bitmap wheatDrawableBitmap;
	static Bitmap maChangDrawableBitmap;
	static Bitmap xueTangDrawableBitmap;
	static Bitmap zhanXianGuanDrawableBitmap;
	static Bitmap palaceDrawableBitmap;
	
	static MyMeetableDrawable[][] mapData;
	static Bitmap[] bitmaps;
	
	public static void initBitmap(){
		forestDrawableBitmap = BitmapFactory.decodeResource(resources, R.drawable.senlin);
		treeDrawableBitmap = BitmapFactory.decodeResource(resources, R.drawable.tree);
		moZiDrawableBitmap = BitmapFactory.decodeResource(resources, R.drawable.mozi);
		yiZhanDrawableBitmap = BitmapFactory.decodeResource(resources, R.drawable.yizhan);
		fishingDrawableBitmap = BitmapFactory.decodeResource(resources, R.drawable.yuchang);
		cityDrawableBitmap = BitmapFactory.decodeResource(resources, R.drawable.chengshi);
		mineDrawableBitmap = BitmapFactory.decodeResource(resources, R.drawable.kuangshan);
		riceDrawableBitmap = BitmapFactory.decodeResource(resources, R.drawable.daotian);
		tieJangPuDrawableBitmap = BitmapFactory.decodeResource(resources, R.drawable.tiejiangpu);
		villageDrawableBitmap = BitmapFactory.decodeResource(resources, R.drawable.cunzhuang);
		luBanDrawableBitmap = BitmapFactory.decodeResource(resources, R.drawable.luban);
		wuGuanDrawableBitmap = BitmapFactory.decodeResource(resources, R.drawable.wuguan);
		xueTangDrawableBitmap = BitmapFactory.decodeResource(resources, R.drawable.xuetang);
		wheatDrawableBitmap = BitmapFactory.decodeResource(resources, R.drawable.maitian);
		bmpDialogBack = BitmapFactory.decodeResource(resources, R.drawable.dialog_back);
		sunZiDrawableBitmap = BitmapFactory.decodeResource(resources, R.drawable.sunzi);
		maChangDrawableBitmap = BitmapFactory.decodeResource(resources, R.drawable.machang);
		zhanXianGuanDrawableBitmap = BitmapFactory.decodeResource(resources, R.drawable.zhaoxianguan);
		palaceDrawableBitmap = BitmapFactory.decodeResource(resources, R.drawable.huangcheng);
		
		
		Bitmap bmpTemp = BitmapFactory.decodeResource(resources, R.drawable.buttons);
        bmpDialogButton = Bitmap.createBitmap(bmpTemp, 0, 0, 60, 30);
        bmpTemp = null;
		 
		bitmaps = new Bitmap[]
        {
				forestDrawableBitmap,
				treeDrawableBitmap,
				moZiDrawableBitmap ,
				yiZhanDrawableBitmap,
				fishingDrawableBitmap,
				cityDrawableBitmap,
				mineDrawableBitmap,
				riceDrawableBitmap,
				tieJangPuDrawableBitmap,
				villageDrawableBitmap,
				luBanDrawableBitmap,
				wuGuanDrawableBitmap,
				xueTangDrawableBitmap,
				wheatDrawableBitmap,
				sunZiDrawableBitmap,
				maChangDrawableBitmap,
				zhanXianGuanDrawableBitmap,
				palaceDrawableBitmap,
        };

		
	}
	
	public static void initMapData(){	
		//二维数组为一个MyDrawable对象的引用
		mapData = new MyMeetableDrawable [40][60];
		try {
			InputStream in = resources.getAssets().open("mapsu.so");
			DataInputStream din = new DataInputStream(in);
			int totalBlocks = din.readInt();
			
			for(int i=0; i<totalBlocks; i++){
				
				int outBitmapInxex = din.readByte();
				int kyf=din.readByte();//可遇否，1—可遇
				int w = din.readByte();//图元的宽度
				int h = din.readByte();//图元的高度
				int col = din.readByte();//总列数
				int row = din.readByte();//总行数
				int pCol = din.readByte();//占位列
				int pRow = din.readByte();//占位行
				
				int bktgCount=din.readByte();//不可通过点的数量
				int[][] notIn=new int[bktgCount][2];
				
				for(int j=0; j<bktgCount; j++){
					notIn[j][0] = din.readByte();
					notIn[j][1] = din.readByte();
				}
				
				int keYuCount = din.readByte();//可遇点的数量
				int[][] keYu=new int[keYuCount][2];
				for(int j=0; j<keYuCount; j++){
					keYu[j][0] = din.readByte();
					keYu[j][1] = din.readByte();
				}
				
				if(outBitmapInxex==0){//Forest
					mapData[row][col]=new ForestDrawable
					(
							bitmaps[outBitmapInxex],
							bmpDialogBack,
							bmpDialogButton,
							((kyf==0)?false:true), 
							w, 
							h, 
							col, 
							row, 
							pCol, 
							pRow, 
							notIn,
							keYu
					);					
				}
				else if(outBitmapInxex==1){//Tree
					mapData[row][col]=new TreeDrawable
					(
							bitmaps[outBitmapInxex],
							bmpDialogBack,
							bmpDialogButton,
							((kyf==0)?false:true), 
							w, 
							h, 
							col, 
							row, 
							pCol, 
							pRow, 
							notIn,
							keYu
					);					
				}
				else if(outBitmapInxex==2){//MoZi
					mapData[row][col]=new MoZiDrawable
					(
							bitmaps[outBitmapInxex],
							bmpDialogBack,
							bmpDialogButton,
							((kyf==0)?false:true), 
							w, 
							h, 
							col, 
							row, 
							pCol, 
							pRow, 
							notIn,
							keYu
					);					
				}
				else if(outBitmapInxex==3){//YiZhan
					mapData[row][col]=new YiZhanDrawable
					(
							bitmaps[outBitmapInxex],
							bmpDialogBack,
							bmpDialogButton,
							((kyf==0)?false:true), 
							w, 
							h, 
							col, 
							row, 
							pCol, 
							pRow, 
							notIn,
							keYu
					);					
				}
				else if(outBitmapInxex==4){//Fishing
					mapData[row][col]=new FishingDrawable
					(
							bitmaps[outBitmapInxex],
							bmpDialogBack,
							bmpDialogButton,
							((kyf==0)?false:true), 
							w, 
							h, 
							col, 
							row, 
							pCol, 
							pRow, 
							notIn,
							keYu
					);					
				}
				else if(outBitmapInxex==5)//City
				{
					mapData[row][col]=new CityDrawable
					(
							bitmaps[outBitmapInxex],
							bmpDialogBack,
							bmpDialogButton,
							((kyf==0)?false:true), 
							w, 
							h, 
							col, 
							row, 
							pCol, 
							pRow, 
							notIn,
							keYu
					);
				}
				else if(outBitmapInxex==6)//Mine
				{
					mapData[row][col]=new MineDrawable
					(
							bitmaps[outBitmapInxex],
							bmpDialogBack,
							bmpDialogButton,
							((kyf==0)?false:true), 
							w, 
							h, 
							col, 
							row, 
							pCol, 
							pRow, 
							notIn,
							keYu
					);
				}
				else if(outBitmapInxex==7)//Rice
				{
					mapData[row][col]=new RiceDrawable
					(
							bitmaps[outBitmapInxex],
							bmpDialogBack,
							bmpDialogButton,
							((kyf==0)?false:true), 
							w, 
							h, 
							col, 
							row, 
							pCol, 
							pRow, 
							notIn,
							keYu
					);
				}
				else if(outBitmapInxex==8)//TieJangPu
				{
					mapData[row][col]=new TieJangPuDrawable
					(
							bitmaps[outBitmapInxex],
							bmpDialogBack,
							bmpDialogButton,
							((kyf==0)?false:true), 
							w, 
							h, 
							col, 
							row, 
							pCol, 
							pRow, 
							notIn,
							keYu
					);
				}
				else if(outBitmapInxex==9)//Village
				{
					mapData[row][col]=new VillageDrawable
					(
							bitmaps[outBitmapInxex],
							bmpDialogBack,
							bmpDialogButton,
							((kyf==0)?false:true), 
							w, 
							h, 
							col, 
							row, 
							pCol, 
							pRow, 
							notIn,
							keYu
					);
				}
				else if(outBitmapInxex==10)//LuBan
				{
					mapData[row][col]=new LuBanDrawable
					(
							bitmaps[outBitmapInxex],
							bmpDialogBack,
							bmpDialogButton,
							((kyf==0)?false:true), 
							w, 
							h, 
							col, 
							row, 
							pCol, 
							pRow, 
							notIn,
							keYu
					);
				}
				else if(outBitmapInxex==11)//WuGuan
				{
					mapData[row][col]=new WuGuanDrawable
					(
							bitmaps[outBitmapInxex],
							bmpDialogBack,
							bmpDialogButton,
							((kyf==0)?false:true), 
							w, 
							h, 
							col, 
							row, 
							pCol, 
							pRow, 
							notIn,
							keYu
					);
				}
				else if(outBitmapInxex==12)//XueTang
				{
					mapData[row][col]=new XueTangDrawable
					(
							bitmaps[outBitmapInxex],
							bmpDialogBack,
							bmpDialogButton,
							((kyf==0)?false:true), 
							w, 
							h, 
							col, 
							row, 
							pCol, 
							pRow, 
							notIn,
							keYu
					);
				}
				else if(outBitmapInxex==13)//Wheat
				{
					mapData[row][col]=new WheatDrawable
					(
							bitmaps[outBitmapInxex],
							bmpDialogBack,
							bmpDialogButton,
							((kyf==0)?false:true), 
							w, 
							h, 
							col, 
							row, 
							pCol, 
							pRow, 
							notIn,
							keYu
					);
				}
				else if(outBitmapInxex==14)//SunZi
				{
					mapData[row][col]=new SunZiDrawable
					(
							bitmaps[outBitmapInxex],
							bmpDialogBack,
							bmpDialogButton,
							((kyf==0)?false:true), 
							w, 
							h, 
							col, 
							row, 
							pCol, 
							pRow, 
							notIn,
							keYu
					);
				}
				else if(outBitmapInxex==15)//MaChang
				{
					mapData[row][col]=new MaChangDrawable
					(
							bitmaps[outBitmapInxex],
							bmpDialogBack,
							bmpDialogButton,
							((kyf==0)?false:true), 
							w, 
							h, 
							col, 
							row, 
							pCol, 
							pRow, 
							notIn,
							keYu
					);
				}
				else if(outBitmapInxex==16)//ZhanXianGuan
				{
					mapData[row][col]=new ZhanXianGuanDrawable
					(
							bitmaps[outBitmapInxex],
							bmpDialogBack,
							bmpDialogButton,
							((kyf==0)?false:true), 
							w, 
							h, 
							col, 
							row, 
							pCol, 
							pRow, 
							notIn,
							keYu
					);
				}
				else if(outBitmapInxex==17)//Palace
				{
					mapData[row][col]=new PalaceDrawable
					(
							bitmaps[outBitmapInxex],
							bmpDialogBack,
							bmpDialogButton,
							((kyf==0)?false:true), 
							w, 
							h, 
							col, 
							row, 
							pCol, 
							pRow, 
							notIn,
							keYu
					);
				}
			}
			
			
			din.close();
			in.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
