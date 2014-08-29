package wyf.ytl.data;

import java.util.ArrayList;

import wyf.ytl.entity.General;

import static wyf.ytl.tool.ConstantUtil.*;

public class CityInfo { 
	public String cityName;//�ǳ�����
	public int country;//��������
	public int army;//����
	public int food;//����
	public int level;//�ȼ�
	public int baseAttack = 20;//ÿ��ʿ���Ļ���������
	public int baseDefend = 15;//ÿ��ʿ���Ļ���������
	public int citizen;//����
	public int warTank = 0;//ս���ĸ������������ӹ�����
	public int warTower = 0;//����ĸ����������ӷ�����
	
	public final int info;
	public ArrayList<General> guardGeneral = new ArrayList<General>();//�佫�б�
	
	public CityInfo(String cityName, int country, int army, int food,
			int level, int baseAttack, int baseDefend, int citizen,
			int warTank, int warTower, General guardGeneral,int info) {//������
		this.cityName = cityName;
		this.country = country;
		this.army = army;
		this.food = food;
		this.level = level;
		this.baseAttack = baseAttack;
		this.baseDefend = baseDefend;
		this.citizen = citizen;
		this.warTank = warTank;
		this.warTower = warTower;
		this.guardGeneral.add(guardGeneral);
		this.info = info;
	}	
	
	public void setBackToInit(){//�ָ���Ĭ��		
		for(int i=0; i<CITY_INFO.size(); i++){
			CityInfo ci = CITY_INFO.get(i);
			if(ci.info == this.info){
				this.cityName = ci.cityName;
				this.country = ci.country;
				this.army = ci.army;
				this.food = ci.food;
				this.level = ci.level;
				this.baseAttack = ci.baseAttack;
				this.baseDefend = ci.baseDefend;
				this.citizen = ci.citizen;
				this.warTank = ci.warTank;
				this.warTower = ci.warTower;
				this.guardGeneral = ci.guardGeneral;
				break;
			}
		}
	}
}
