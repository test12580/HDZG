/*********************************************************************
	Rhapsody	: 8.1
	Login		: Kevin
	Component	: HDZGComponent
	Configuration 	: HDZG
	Model Element	: Hero
//!	Generated Date	: 周五, 1, 八月 2014 
	File Path	: G:/Android/workspace/HDZG/src/wyf/ytl/entity/Hero.java
*********************************************************************/

package wyf.ytl.entity;

//## auto_generated
import java.util.*;
//## dependency Random 
import java.util.Random;
//## dependency HashMap 
import java.util.HashMap;
//## dependency ArrayList 
import java.util.ArrayList;
//## dependency IOException 
import java.io.IOException;
//## dependency ObjectInput 
import java.io.ObjectInput;
//## dependency ObjectOutput 
import java.io.ObjectOutput;
//## dependency GameView 
import wyf.ytl.view.GameView;
//## dependency Externalizable 
import java.io.Externalizable;
//## dependency Bitmap 
import android.graphics.Bitmap;
//## dependency Canvas 
import android.graphics.Canvas;
//## dependency ConstantUtil 
import static wyf.ytl.tool.ConstantUtil.*;

//----------------------------------------------------------------------------
// wyf/ytl/entity/Hero.java                                                                  
//----------------------------------------------------------------------------

//## package HDZG::wyf::ytl::entity 


/**
 * 
 * 此类为游戏中一个重要的类，封装了玩家的所有游戏信息，以及一些游戏中需要用到的方法
 * 在该类中既包含英雄的个人属性，也包含其手下的将领列表，拥有的城池列表等
*/
//## class Hero 
public class Hero implements Externalizable {
    
    private static final long serialVersionUID = -5433306195939766058L;		//## attribute serialVersionUID 
    
    private String name = "段世雄";		//## attribute name 
    
    /**
     * 英雄体力，
    */
    public int strength = 100;		//## attribute strength 
    
    /**
     * 体力上限，会随着等级增加
    */
    public int maxStrength = 100;		//## attribute maxStrength 
    
    /**
     * 英雄等级
    */
    public int level = 1;		//## attribute level 
    
    /**
     * 英雄的移动方向，4：下，5：左，6:右，7：上。同时也代表当前英雄的动画段号，从零开始
    */
    public int direction = -1;		//## attribute direction 
    
    /**
     * 当前英雄的动画段的当前动画帧，从零开始
    */
    int currentFrame = 0;		//## attribute currentFrame 
    
    /**
     * 随身携带的粮草，不包括每个城池中的粮食
    */
    int food = 10000;		//## attribute food 
    
    /**
     * 总金钱
    */
    int totalMoney = 6000;		//## attribute totalMoney 
    
    /**
     * 跟随自己的军队
    */
    public int armyWithMe = 6000;		//## attribute armyWithMe 
    
    /**
     * 总军队，包括跟随自己的和守城在家的
    */
    int totalArmy;		//## attribute totalArmy 
    
    /**
     * 英雄的定位点在大地图中的列，定位点为下面的格子的中心
    */
    public int col;		//## attribute col 
    
    /**
     * 英雄的定位点在大地图中的行，定位点为下面的格子的中心
    */
    public int row;		//## attribute row 
    
    /**
     * 英雄『中心点』的x坐标，用于绘制 
    */
    public int x;		//## attribute x 
    
    /**
     * 英雄『中心点』的y坐标，用于绘制
    */
    public int y;		//## attribute y 
    
    /**
     * 英雄的宽度=======在initAnimationSegment方法中初始化
    */
    int width;		//## attribute width 
    
    /**
     * 英雄的高度=======在initAnimationSegment方法中初始化
    */
    int height;		//## attribute height 
    
    /**
     * 官衔 
    */
    int title = 0;		//## attribute title 
    
    /**
     * 随身携带的战车
    */
    public int warTank = 0;		//## attribute warTank 
    
    /**
     * 随身携带的箭垛
    */
    public int warTower = 0;		//## attribute warTower 
    
    int strengthGrowSpan = 1;		//## attribute strengthGrowSpan 
    
    /**
     * 基础攻击力
    */
    public int basicAttack = 18;		//## attribute basicAttack 
    
    /**
     * 基础防御力
    */
    public int basicDefend = 18;		//## attribute basicDefend 
    
    /**
     * 存放英雄所有的动画段，每个动画段为一个一维数组
    */
    ArrayList<Bitmap[]> animationSegment = new ArrayList<Bitmap []>();		//## attribute animationSegment 
    
    /**
     * 存放英雄的所有技能
    */
    HashMap<Integer, Skill> heroSkill = new HashMap<Integer,Skill>();		//## attribute heroSkill 
    
    /**
     * 我方可能得到的将领
    */
    public static ArrayList<General> MY_GENERAL = new ArrayList<General>();		//## link MY_GENERAL 
    
    /**
     * Activity引用
    */
    public GameView father;		//## link father 
    
    /**
     * 存放英雄拥有的城池
    */
    public ArrayList<CityDrawable> cityList = new ArrayList<CityDrawable>();		//## link cityList 
    
    /**
     * 存放【跟随】英雄的将领
    */
    ArrayList<General> generalList = new ArrayList<General>();		//## link generalList 
    
    /**
     * 存放现有的科研项目
    */
    ArrayList<Research> researchList = new ArrayList<Research>();		//## link researchList 
    
    /**
     * 负责英雄动画换帧的线程
    */
    public Hero.HeroThread ht;		//## link ht 
    
    /**
     * 负责英雄走路的线程
    */
    public HeroGoThread hgt;		//## link hgt 
    
    /**
     * 负责英雄走路的线程
     * 负责后台数据更改的线程，如粮草减少，科研进度/敌人来袭等
    */
    public HeroBackDataThread hbdt;		//## link hbdt 
    
    
    // Constructors
    
    //## operation Hero() 
    public  Hero() {
        //#[ operation Hero() 
        //#]
    }
    
    /**
     * @param out
    */
    //## operation writeExternal(ObjectOutput) 
    public void writeExternal(ObjectOutput out) throws IOException {
        //#[ operation writeExternal(ObjectOutput) 
        out.writeObject(name);
        out.writeInt(strength);
        out.writeInt(maxStrength);
        out.writeInt(level);
        out.writeInt(direction);
        out.writeInt(currentFrame);
        out.writeInt(food);
        out.writeInt(totalMoney);
        out.writeInt(armyWithMe);
        out.writeInt(totalArmy);
        out.writeInt(col);
        out.writeInt(row);
        out.writeInt(x);
        out.writeInt(y);
        out.writeInt(width);
        out.writeInt(height);
        out.writeInt(title);
        out.writeInt(warTank);
        out.writeInt(warTower);
        out.writeInt(strengthGrowSpan);
        out.writeInt(basicAttack);
        out.writeInt(basicDefend);
        out.writeObject(cityList);
        out.writeObject(generalList);
        out.writeObject(researchList);
        out.writeObject(heroSkill);
        out.writeObject(MY_GENERAL);
        //#]
    }
    
    /**
     * @param in
    */
    @SuppressWarnings("unchecked")
    //## operation readExternal(ObjectInput) 
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        //#[ operation readExternal(ObjectInput) 
        name = (String) in.readObject();
        this.strength = in.readInt();
        this.maxStrength = in.readInt();
        this.level = in.readInt();
        direction = in.readInt();
        currentFrame = in.readInt();
        food = in.readInt();
        totalMoney = in.readInt();
        armyWithMe = in.readInt();
        totalArmy = in.readInt();
        col = in.readInt();
        row = in.readInt();
        x = in.readInt();
        y = in.readInt();
        width = in.readInt();
        height = in.readInt();
        title = in.readInt();
        warTank = in.readInt();
        warTower = in.readInt();
        strengthGrowSpan = in.readInt();
        basicAttack = in.readInt();
        basicDefend = in.readInt();
        cityList = (ArrayList<CityDrawable>) in.readObject();
        generalList = (ArrayList<General>) in.readObject();		
        researchList = (ArrayList<Research>) in.readObject();
        heroSkill = (HashMap<Integer, Skill>) in.readObject();
        MY_GENERAL=(ArrayList<General>)in.readObject();
        
        //恢复相关信息和数据 
        ht = new HeroThread();
        
        initHeroSkills();	
        //#]
    }
    /**
     * 构造器：
     * @param father
     * @param col
     * @param row
    */
    //## operation Hero(GameView,int,int) 
    public  Hero(GameView father, int col, int row) {
        //#[ operation Hero(GameView,int,int) 
        this.col = col;
        this.row = row;
        this.x = col*TILE_SIZE+TILE_SIZE/2+1;
        this.y = row*TILE_SIZE+TILE_SIZE/2+1;
        this.father = father;
        ht = new HeroThread();
        hgt = new HeroGoThread(father,this);
        hbdt = new HeroBackDataThread(this);
        hbdt.start();
        initHeroSkills();	
        //#]
    }
    
    /**
     * 方法：初始化动画段列表
     * @param segments
    */
    //## operation initAnimationSegment(Bitmap[][]) 
    public void initAnimationSegment(Bitmap[][] segments) {
        //#[ operation initAnimationSegment(Bitmap[][]) 
        for(Bitmap [] segment:segments){
        	addAnimationSegment(segment);
        }
        this.height = segments[0][0].getHeight();//初始化英雄图片高度
        this.width = segments[0][0].getWidth();//初始化英雄图片宽度
        //#]
    }
    
    /**
     * 方法：向动画段列表中添加动画段,该方法会在初始化动画段列表中被调用
     * @param segment
    */
    //## operation addAnimationSegment(Bitmap[]) 
    public void addAnimationSegment(Bitmap[] segment) {
        //#[ operation addAnimationSegment(Bitmap[]) 
        this.animationSegment.add(segment);
        //#]
    }
    
    /**
     * 方法：设置方向，同时也是动画段索引
     * @param direction
    */
    //## operation setAnimationDirection(int) 
    public void setAnimationDirection(int direction) {
        //#[ operation setAnimationDirection(int) 
        this.direction = direction;
        //#]
    }
    
    /**
     * 方法：开始换帧动画
    */
    //## operation startAnimation() 
    public void startAnimation() {
        //#[ operation startAnimation() 
        ht.isGameOn = true;//设置换帧标志位为真
        if(!ht.isAlive()){//如果换帧线程没有启动则启动它
        	ht.start();
        }
        //#]
    }
    
    /**
     * 方法：暂停动画
    */
    //## operation pauseAnimation() 
    public void pauseAnimation() {
        //#[ operation pauseAnimation() 
        if(ht != null){//如果换帧线程存在，就设置换帧标志位为假
        	ht.isGameOn = false;
        }
        //#]
    }
    
    /**
     * 方法：销毁动画及其换帧线程
    */
    //## operation destroyAnimation() 
    public void destroyAnimation() {
        //#[ operation destroyAnimation() 
        ht.isGameOn = false;//停止换帧
        ht.flag = false;//停止线程的run方法
        ht = null;//释放对象
        //#]
    }
    
    /**
     * 方法：在屏幕上绘制自己,根据传入的屏幕定位row和col计算出相对坐标画出
     * @param canvas
     * @param startRow
     * @param startCol
     * @param offsetX
     * @param offsetY
    */
    //## operation drawSelf(Canvas,int,int,int,int) 
    public void drawSelf(Canvas canvas, int startRow, int startCol, int offsetX, int offsetY) {
        //#[ operation drawSelf(Canvas,int,int,int,int) 
        if(direction>animationSegment.size()){
        	return;
        }
        Bitmap bmp = animationSegment.get(direction)[currentFrame];
        int topLeftCornerX = x-TILE_SIZE/2-1 - startCol*TILE_SIZE;//先计算出左上角坐标，再转换成屏幕的相对坐标
        int topLeftCornerY = y+TILE_SIZE/2-height - startRow*TILE_SIZE;//先计算出左上角坐标，再转换成屏幕的相对坐标
        canvas.drawBitmap(bmp, topLeftCornerX-offsetX, topLeftCornerY-offsetY, null);
        //#]
    }
    
    /**
     * 方法：掷骰子方法,接收骰子的个数，返回一个数组表示每个骰子上的点数
     * @param diceNumber
    */
    //## operation throwDice(int) 
    public int[]  throwDice(int diceNumber) {
        //#[ operation throwDice(int) 
        int [] result = new int[3];
        Random random = new Random();
        for(int i=0;i<diceNumber;i++){//根据骰子个数来随机产生骰子
        	result[i] = random.nextInt(32)%6;//注意：产生的是0-5的数，不是1-6
        }
        return result;
        //#]
    }
    
    /**
     * 方法：换帧
    */
    //## operation nextFrame() 
    public void nextFrame() {
        //#[ operation nextFrame() 
        int frameLength = this.animationSegment.get(direction).length;
        this.currentFrame = (this.currentFrame+1)%frameLength;
        //#]
    }
    
    /**
     * 方法：激活英雄的走路线程，传入格子数使其开动
     * @param steps
    */
    //## operation startToGo(int) 
    public void startToGo(int steps) {
        //#[ operation startToGo(int) 
        hgt.setMoving(true);
        hgt.setSteps(steps);	
        if(!hgt.isAlive()){//没启动就启动
        	hgt.start();
        }			
        father.setStatus(1);//为1表示状态为英雄正在走
        //#]
    }
    
    /**
     * 方法：根据英雄移动的增加英雄的体力
     * @param steps
    */
    //## operation growStrength(int) 
    public void growStrength(int steps) {
        //#[ operation growStrength(int) 
        int increment = steps*strengthGrowSpan;
        if(strength+increment < maxStrength){//加不满
        	strength+=increment;
        }
        else{
        	strength = maxStrength;
        }
        //#]
    }
    
    //## operation getTotalFood() 
    public int getTotalFood() {
        //#[ operation getTotalFood() 
        int result = 0;
        for(CityDrawable cd : cityList){
        	result = result+cd.getFood();//加上每个城池的
        }
        result += this.food;//加上随身携带的
        return result;
        //#]
    }
    
    //## operation getGeneralNumber() 
    public int getGeneralNumber() {
        //#[ operation getGeneralNumber() 
        //得到英雄所拥有的所有将军
        		int result = 0;
        		for(CityDrawable cd : cityList){
        			result = result+cd.guardGeneral.size();
        		}
        		result += generalList.size();
        		return result;
        //#]
    }
    
    /**
     * 方法：初始化英雄的技能
    */
    //## operation initHeroSkills() 
    public void initHeroSkills() {
        //#[ operation initHeroSkills() 
        //技能类型，包括0:生活技能、1:战斗技能、2:普通技能
        	LumberSkill ls = new LumberSkill(LUMBER, "伐木", 500, 0, this);
        	this.heroSkill.put(ls.id, ls); 
        	FishingSkill fishingSkill = new FishingSkill(FISHING,"捕鱼",500, 0, this);
        	this.heroSkill.put(fishingSkill.id, fishingSkill);
        	MiningSkill miningSkill = new MiningSkill(MINING, "采矿", 500, 0, this);
        	this.heroSkill.put(miningSkill.id, miningSkill);
        	FarmingSkill farmSkill = new FarmingSkill(FARMING, "农耕", 500, 0, this);
        	this.heroSkill.put(farmSkill.id, farmSkill);	
        	SuiXinBuSkill s = new SuiXinBuSkill(SUI_XIN_BU, "随心步", -1, 1, this);
        	this.heroSkill.put(s.id, s);
        //#]
    }
    
    /**
     * @param general
    */
    //## operation setHeroGeneral(General) 
    public void setHeroGeneral(General general) {
        //#[ operation setHeroGeneral(General) 
        this.generalList.add(general);
        //#]
    }
    
    //## operation getName() 
    public String getName() {
        //#[ operation getName() 
        return name;
        //#]
    }
    
    //## operation getStrength() 
    public int getStrength() {
        //#[ operation getStrength() 
        return strength;
        //#]
    }
    
    /**
     * @param strength
    */
    //## operation setStrength(int) 
    public void setStrength(int strength) {
        //#[ operation setStrength(int) 
        this.strength = strength;
        //#]
    }
    
    //## operation getMaxStrength() 
    public int getMaxStrength() {
        //#[ operation getMaxStrength() 
        return maxStrength;
        //#]
    }
    
    /**
     * @param maxStrength
    */
    //## operation setMaxStrength(int) 
    public void setMaxStrength(int maxStrength) {
        //#[ operation setMaxStrength(int) 
        this.maxStrength = maxStrength;
        //#]
    }
    
    //## operation getLevel() 
    public int getLevel() {
        //#[ operation getLevel() 
        return level;
        //#]
    }
    
    /**
     * @param level
    */
    //## operation setLevel(int) 
    public void setLevel(int level) {
        //#[ operation setLevel(int) 
        this.level = level;
        //#]
    }
    
    //## operation getCurrentFrame() 
    public int getCurrentFrame() {
        //#[ operation getCurrentFrame() 
        return currentFrame;
        //#]
    }
    
    /**
     * @param currentFrame
    */
    //## operation setCurrentFrame(int) 
    public void setCurrentFrame(int currentFrame) {
        //#[ operation setCurrentFrame(int) 
        this.currentFrame = currentFrame;
        //#]
    }
    
    //## operation getFood() 
    public int getFood() {
        //#[ operation getFood() 
        return food;
        //#]
    }
    
    /**
     * @param food
    */
    //## operation setFood(int) 
    public void setFood(int food) {
        //#[ operation setFood(int) 
        this.food = food;
        //#]
    }
    
    //## operation getRow() 
    public int getRow() {
        //#[ operation getRow() 
        return row;
        //#]
    }
    
    /**
     * @param row
    */
    //## operation setRow(int) 
    public void setRow(int row) {
        //#[ operation setRow(int) 
        this.row = row;
        //#]
    }
    
    //## operation getTitle() 
    public String getTitle() {
        //#[ operation getTitle() 
        return HERO_TITLE[title];
        //#]
    }
    
    /**
     * @param title
    */
    //## operation setTitle(int) 
    public void setTitle(int title) {
        //#[ operation setTitle(int) 
        this.title = title;
        //#]
    }
    
    //## operation getHeroSkill() 
    public HashMap<Integer, Skill>  getHeroSkill() {
        //#[ operation getHeroSkill() 
        return heroSkill;
        //#]
    }
    
    /**
     * @param heroSkill
    */
    //## operation setHeroSkill(HashMap<Integer, Skill>) 
    public void setHeroSkill(HashMap<Integer, Skill> heroSkill) {
        //#[ operation setHeroSkill(HashMap<Integer, Skill>) 
        this.heroSkill = heroSkill;
        //#]
    }
    
    //## operation getGeneralList() 
    public ArrayList<General>  getGeneralList() {
        //#[ operation getGeneralList() 
        return generalList;
        //#]
    }
    
    /**
     * @param generalList
    */
    //## operation setGeneralList(ArrayList<General>) 
    public void setGeneralList(ArrayList<General> generalList) {
        //#[ operation setGeneralList(ArrayList<General>) 
        this.generalList = generalList;
        //#]
    }
    
    //## operation getCityList() 
    public ArrayList<CityDrawable>  getCityList() {
        //#[ operation getCityList() 
        return cityList;
        //#]
    }
    
    //## operation getResearchList() 
    public ArrayList<Research>  getResearchList() {
        //#[ operation getResearchList() 
        return researchList;
        //#]
    }
    
    //## operation getArmyWithMe() 
    public int getArmyWithMe() {
        //#[ operation getArmyWithMe() 
        return armyWithMe;
        //#]
    }
    
    /**
     * @param armyWithMe
    */
    //## operation setArmyWithMe(int) 
    public void setArmyWithMe(int armyWithMe) {
        //#[ operation setArmyWithMe(int) 
        this.armyWithMe = armyWithMe;
        //#]
    }
    
    //## operation getTotalMoney() 
    public int getTotalMoney() {
        //#[ operation getTotalMoney() 
        return totalMoney;
        //#]
    }
    
    /**
     * @param totalMoney
    */
    //## operation setTotalMoney(int) 
    public void setTotalMoney(int totalMoney) {
        //#[ operation setTotalMoney(int) 
        this.totalMoney = totalMoney;
        //#]
    }
    
    //## operation getTotalArmy() 
    public int getTotalArmy() {
        //#[ operation getTotalArmy() 
        int result = this.getArmyWithMe();
        for(CityDrawable cd : cityList){
        	result = result+cd.getArmy();//加上每个城池的
        }
        return result;		
        //#]
    }
    
    /**
     * @param totalArmy
    */
    //## operation setTotalArmy(int) 
    public void setTotalArmy(int totalArmy) {
        //#[ operation setTotalArmy(int) 
        this.totalArmy = totalArmy;
        //#]
    }
    
    //## operation getTotalCitizen() 
    public int getTotalCitizen() {
        //#[ operation getTotalCitizen() 
        //得到总居民人口
        		int result = 0;
        		for(CityDrawable cd : cityList){
        			result = result+cd.getCitizen();//加上每个城池的
        		}
        		return result;
        //#]
    }
    
    //## operation getTotalWarTank() 
    public int getTotalWarTank() {
        //#[ operation getTotalWarTank() 
        //得到战车数量
        		int result = 0;
        		for(CityDrawable cd : cityList){
        			result = result+cd.getWarTank();//加上每个城池的
        		}
        		result += this.warTank;//加上自身的
        		return result;
        //#]
    }
    
    //## operation getTotalWarTower() 
    public int getTotalWarTower() {
        //#[ operation getTotalWarTower() 
        //得到战车数量
        		int result = 0;
        		for(CityDrawable cd : cityList){
        			result = result+cd.getWarTower();//加上每个城池的
        		}
        		result += this.warTower;//加上自身的
        		return result;
        //#]
    }
    
    //## operation getTotalGeneral() 
    public ArrayList<General>  getTotalGeneral() {
        //#[ operation getTotalGeneral() 
        //得到所有的将领，包括自己城池中的
        		ArrayList<General> result = new ArrayList<General>();
        		result.addAll(generalList);//将跟随的将领添加到列表
        		for(CityDrawable cb : cityList){//添加各个城池中的将领
        			result.addAll(cb.getGuardGeneral());
        		}
        		return result;
        //#]
    }
    
    //## operation getWarTank() 
    public int getWarTank() {
        //#[ operation getWarTank() 
        return warTank;
        //#]
    }
    
    /**
     * @param warTank
    */
    //## operation setWarTank(int) 
    public void setWarTank(int warTank) {
        //#[ operation setWarTank(int) 
        this.warTank = warTank;
        //#]
    }
    
    //## operation getWarTower() 
    public int getWarTower() {
        //#[ operation getWarTower() 
        return warTower;
        //#]
    }
    
    /**
     * @param warTower
    */
    //## operation setWarTower(int) 
    public void setWarTower(int warTower) {
        //#[ operation setWarTower(int) 
        this.warTower = warTower;
        //#]
    }
    
    /**
     * 内部线程类：负责定时更改英雄的动画帧，但是不负责改变动画段
    */
    //## class Hero::HeroThread 
    public class HeroThread extends Thread {
        
        /**
         * 线程的run方法是否执行的标志位
        */
        public boolean flag;		//## attribute flag 
        
        /**
         * 是否进行换帧的标志位
        */
        public boolean isGameOn;		//## attribute isGameOn 
        
        
        // Constructors
        
        //## operation HeroThread() 
        public  HeroThread() {
            //#[ operation HeroThread() 
            super.setName("==Hero.HeroThread");
            flag = true;
            //#]
        }
        
        //## operation run() 
        public void run() {
            //#[ operation run() 
            while(flag){
            	while(isGameOn){
            		try{
            			nextFrame();//进行换帧操作
            		}
            		catch(Exception e){
            		}
            		try{
            			Thread.sleep(HERO_ANIMATION_SLEEP_SPAN);
            		}
            		catch(Exception e){
            			e.printStackTrace();
            		}
            	}
            	//空转的时候也要睡眠
            	try{
            		Thread.sleep(HERO_NO_ANIMATION_SLEEP_SPAN);
            	}
            	catch(Exception e){
            		e.printStackTrace();
            	}
            }
            //#]
        }
        
    }
}
/*********************************************************************
	File Path	: G:/Android/workspace/HDZG/src/wyf/ytl/entity/Hero.java
*********************************************************************/

