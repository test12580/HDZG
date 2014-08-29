/*********************************************************************
	Rhapsody	: 8.1
	Login		: Kevin
	Component	: HDZGComponent
	Configuration 	: HDZG
	Model Element	: Hero
//!	Generated Date	: ����, 1, ���� 2014 
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
 * ����Ϊ��Ϸ��һ����Ҫ���࣬��װ����ҵ�������Ϸ��Ϣ���Լ�һЩ��Ϸ����Ҫ�õ��ķ���
 * �ڸ����мȰ���Ӣ�۵ĸ������ԣ�Ҳ���������µĽ����б�ӵ�еĳǳ��б��
*/
//## class Hero 
public class Hero implements Externalizable {
    
    private static final long serialVersionUID = -5433306195939766058L;		//## attribute serialVersionUID 
    
    private String name = "������";		//## attribute name 
    
    /**
     * Ӣ��������
    */
    public int strength = 100;		//## attribute strength 
    
    /**
     * �������ޣ������ŵȼ�����
    */
    public int maxStrength = 100;		//## attribute maxStrength 
    
    /**
     * Ӣ�۵ȼ�
    */
    public int level = 1;		//## attribute level 
    
    /**
     * Ӣ�۵��ƶ�����4���£�5����6:�ң�7���ϡ�ͬʱҲ����ǰӢ�۵Ķ����κţ����㿪ʼ
    */
    public int direction = -1;		//## attribute direction 
    
    /**
     * ��ǰӢ�۵Ķ����εĵ�ǰ����֡�����㿪ʼ
    */
    int currentFrame = 0;		//## attribute currentFrame 
    
    /**
     * ����Я�������ݣ�������ÿ���ǳ��е���ʳ
    */
    int food = 10000;		//## attribute food 
    
    /**
     * �ܽ�Ǯ
    */
    int totalMoney = 6000;		//## attribute totalMoney 
    
    /**
     * �����Լ��ľ���
    */
    public int armyWithMe = 6000;		//## attribute armyWithMe 
    
    /**
     * �ܾ��ӣ����������Լ��ĺ��س��ڼҵ�
    */
    int totalArmy;		//## attribute totalArmy 
    
    /**
     * Ӣ�۵Ķ�λ���ڴ��ͼ�е��У���λ��Ϊ����ĸ��ӵ�����
    */
    public int col;		//## attribute col 
    
    /**
     * Ӣ�۵Ķ�λ���ڴ��ͼ�е��У���λ��Ϊ����ĸ��ӵ�����
    */
    public int row;		//## attribute row 
    
    /**
     * Ӣ�ۡ����ĵ㡻��x���꣬���ڻ��� 
    */
    public int x;		//## attribute x 
    
    /**
     * Ӣ�ۡ����ĵ㡻��y���꣬���ڻ���
    */
    public int y;		//## attribute y 
    
    /**
     * Ӣ�۵Ŀ��=======��initAnimationSegment�����г�ʼ��
    */
    int width;		//## attribute width 
    
    /**
     * Ӣ�۵ĸ߶�=======��initAnimationSegment�����г�ʼ��
    */
    int height;		//## attribute height 
    
    /**
     * ���� 
    */
    int title = 0;		//## attribute title 
    
    /**
     * ����Я����ս��
    */
    public int warTank = 0;		//## attribute warTank 
    
    /**
     * ����Я���ļ���
    */
    public int warTower = 0;		//## attribute warTower 
    
    int strengthGrowSpan = 1;		//## attribute strengthGrowSpan 
    
    /**
     * ����������
    */
    public int basicAttack = 18;		//## attribute basicAttack 
    
    /**
     * ����������
    */
    public int basicDefend = 18;		//## attribute basicDefend 
    
    /**
     * ���Ӣ�����еĶ����Σ�ÿ��������Ϊһ��һά����
    */
    ArrayList<Bitmap[]> animationSegment = new ArrayList<Bitmap []>();		//## attribute animationSegment 
    
    /**
     * ���Ӣ�۵����м���
    */
    HashMap<Integer, Skill> heroSkill = new HashMap<Integer,Skill>();		//## attribute heroSkill 
    
    /**
     * �ҷ����ܵõ��Ľ���
    */
    public static ArrayList<General> MY_GENERAL = new ArrayList<General>();		//## link MY_GENERAL 
    
    /**
     * Activity����
    */
    public GameView father;		//## link father 
    
    /**
     * ���Ӣ��ӵ�еĳǳ�
    */
    public ArrayList<CityDrawable> cityList = new ArrayList<CityDrawable>();		//## link cityList 
    
    /**
     * ��š����桿Ӣ�۵Ľ���
    */
    ArrayList<General> generalList = new ArrayList<General>();		//## link generalList 
    
    /**
     * ������еĿ�����Ŀ
    */
    ArrayList<Research> researchList = new ArrayList<Research>();		//## link researchList 
    
    /**
     * ����Ӣ�۶�����֡���߳�
    */
    public Hero.HeroThread ht;		//## link ht 
    
    /**
     * ����Ӣ����·���߳�
    */
    public HeroGoThread hgt;		//## link hgt 
    
    /**
     * ����Ӣ����·���߳�
     * �����̨���ݸ��ĵ��̣߳������ݼ��٣����н���/������Ϯ��
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
        
        //�ָ������Ϣ������ 
        ht = new HeroThread();
        
        initHeroSkills();	
        //#]
    }
    /**
     * ��������
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
     * ��������ʼ���������б�
     * @param segments
    */
    //## operation initAnimationSegment(Bitmap[][]) 
    public void initAnimationSegment(Bitmap[][] segments) {
        //#[ operation initAnimationSegment(Bitmap[][]) 
        for(Bitmap [] segment:segments){
        	addAnimationSegment(segment);
        }
        this.height = segments[0][0].getHeight();//��ʼ��Ӣ��ͼƬ�߶�
        this.width = segments[0][0].getWidth();//��ʼ��Ӣ��ͼƬ���
        //#]
    }
    
    /**
     * �������򶯻����б�����Ӷ�����,�÷������ڳ�ʼ���������б��б�����
     * @param segment
    */
    //## operation addAnimationSegment(Bitmap[]) 
    public void addAnimationSegment(Bitmap[] segment) {
        //#[ operation addAnimationSegment(Bitmap[]) 
        this.animationSegment.add(segment);
        //#]
    }
    
    /**
     * ���������÷���ͬʱҲ�Ƕ���������
     * @param direction
    */
    //## operation setAnimationDirection(int) 
    public void setAnimationDirection(int direction) {
        //#[ operation setAnimationDirection(int) 
        this.direction = direction;
        //#]
    }
    
    /**
     * ��������ʼ��֡����
    */
    //## operation startAnimation() 
    public void startAnimation() {
        //#[ operation startAnimation() 
        ht.isGameOn = true;//���û�֡��־λΪ��
        if(!ht.isAlive()){//�����֡�߳�û��������������
        	ht.start();
        }
        //#]
    }
    
    /**
     * ��������ͣ����
    */
    //## operation pauseAnimation() 
    public void pauseAnimation() {
        //#[ operation pauseAnimation() 
        if(ht != null){//�����֡�̴߳��ڣ������û�֡��־λΪ��
        	ht.isGameOn = false;
        }
        //#]
    }
    
    /**
     * ���������ٶ������任֡�߳�
    */
    //## operation destroyAnimation() 
    public void destroyAnimation() {
        //#[ operation destroyAnimation() 
        ht.isGameOn = false;//ֹͣ��֡
        ht.flag = false;//ֹͣ�̵߳�run����
        ht = null;//�ͷŶ���
        //#]
    }
    
    /**
     * ����������Ļ�ϻ����Լ�,���ݴ������Ļ��λrow��col�����������껭��
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
        int topLeftCornerX = x-TILE_SIZE/2-1 - startCol*TILE_SIZE;//�ȼ�������Ͻ����꣬��ת������Ļ���������
        int topLeftCornerY = y+TILE_SIZE/2-height - startRow*TILE_SIZE;//�ȼ�������Ͻ����꣬��ת������Ļ���������
        canvas.drawBitmap(bmp, topLeftCornerX-offsetX, topLeftCornerY-offsetY, null);
        //#]
    }
    
    /**
     * �����������ӷ���,�������ӵĸ���������һ�������ʾÿ�������ϵĵ���
     * @param diceNumber
    */
    //## operation throwDice(int) 
    public int[]  throwDice(int diceNumber) {
        //#[ operation throwDice(int) 
        int [] result = new int[3];
        Random random = new Random();
        for(int i=0;i<diceNumber;i++){//�������Ӹ����������������
        	result[i] = random.nextInt(32)%6;//ע�⣺��������0-5����������1-6
        }
        return result;
        //#]
    }
    
    /**
     * ��������֡
    */
    //## operation nextFrame() 
    public void nextFrame() {
        //#[ operation nextFrame() 
        int frameLength = this.animationSegment.get(direction).length;
        this.currentFrame = (this.currentFrame+1)%frameLength;
        //#]
    }
    
    /**
     * ����������Ӣ�۵���·�̣߳����������ʹ�俪��
     * @param steps
    */
    //## operation startToGo(int) 
    public void startToGo(int steps) {
        //#[ operation startToGo(int) 
        hgt.setMoving(true);
        hgt.setSteps(steps);	
        if(!hgt.isAlive()){//û����������
        	hgt.start();
        }			
        father.setStatus(1);//Ϊ1��ʾ״̬ΪӢ��������
        //#]
    }
    
    /**
     * ����������Ӣ���ƶ�������Ӣ�۵�����
     * @param steps
    */
    //## operation growStrength(int) 
    public void growStrength(int steps) {
        //#[ operation growStrength(int) 
        int increment = steps*strengthGrowSpan;
        if(strength+increment < maxStrength){//�Ӳ���
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
        	result = result+cd.getFood();//����ÿ���ǳص�
        }
        result += this.food;//��������Я����
        return result;
        //#]
    }
    
    //## operation getGeneralNumber() 
    public int getGeneralNumber() {
        //#[ operation getGeneralNumber() 
        //�õ�Ӣ����ӵ�е����н���
        		int result = 0;
        		for(CityDrawable cd : cityList){
        			result = result+cd.guardGeneral.size();
        		}
        		result += generalList.size();
        		return result;
        //#]
    }
    
    /**
     * ��������ʼ��Ӣ�۵ļ���
    */
    //## operation initHeroSkills() 
    public void initHeroSkills() {
        //#[ operation initHeroSkills() 
        //�������ͣ�����0:����ܡ�1:ս�����ܡ�2:��ͨ����
        	LumberSkill ls = new LumberSkill(LUMBER, "��ľ", 500, 0, this);
        	this.heroSkill.put(ls.id, ls); 
        	FishingSkill fishingSkill = new FishingSkill(FISHING,"����",500, 0, this);
        	this.heroSkill.put(fishingSkill.id, fishingSkill);
        	MiningSkill miningSkill = new MiningSkill(MINING, "�ɿ�", 500, 0, this);
        	this.heroSkill.put(miningSkill.id, miningSkill);
        	FarmingSkill farmSkill = new FarmingSkill(FARMING, "ũ��", 500, 0, this);
        	this.heroSkill.put(farmSkill.id, farmSkill);	
        	SuiXinBuSkill s = new SuiXinBuSkill(SUI_XIN_BU, "���Ĳ�", -1, 1, this);
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
        	result = result+cd.getArmy();//����ÿ���ǳص�
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
        //�õ��ܾ����˿�
        		int result = 0;
        		for(CityDrawable cd : cityList){
        			result = result+cd.getCitizen();//����ÿ���ǳص�
        		}
        		return result;
        //#]
    }
    
    //## operation getTotalWarTank() 
    public int getTotalWarTank() {
        //#[ operation getTotalWarTank() 
        //�õ�ս������
        		int result = 0;
        		for(CityDrawable cd : cityList){
        			result = result+cd.getWarTank();//����ÿ���ǳص�
        		}
        		result += this.warTank;//���������
        		return result;
        //#]
    }
    
    //## operation getTotalWarTower() 
    public int getTotalWarTower() {
        //#[ operation getTotalWarTower() 
        //�õ�ս������
        		int result = 0;
        		for(CityDrawable cd : cityList){
        			result = result+cd.getWarTower();//����ÿ���ǳص�
        		}
        		result += this.warTower;//���������
        		return result;
        //#]
    }
    
    //## operation getTotalGeneral() 
    public ArrayList<General>  getTotalGeneral() {
        //#[ operation getTotalGeneral() 
        //�õ����еĽ��죬�����Լ��ǳ��е�
        		ArrayList<General> result = new ArrayList<General>();
        		result.addAll(generalList);//������Ľ�����ӵ��б�
        		for(CityDrawable cb : cityList){//��Ӹ����ǳ��еĽ���
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
     * �ڲ��߳��ࣺ����ʱ����Ӣ�۵Ķ���֡�����ǲ�����ı䶯����
    */
    //## class Hero::HeroThread 
    public class HeroThread extends Thread {
        
        /**
         * �̵߳�run�����Ƿ�ִ�еı�־λ
        */
        public boolean flag;		//## attribute flag 
        
        /**
         * �Ƿ���л�֡�ı�־λ
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
            			nextFrame();//���л�֡����
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
            	//��ת��ʱ��ҲҪ˯��
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

