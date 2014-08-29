package wyf.ytl.entity;

import static wyf.ytl.tool.ConstantUtil.PROFICIENCY_INCREMENT;
import static wyf.ytl.tool.ConstantUtil.PROFICIENCY_UPGRADE_SPAN;
import static wyf.ytl.tool.ConstantUtil.SKILL_LEVEL_MAX;
import static wyf.ytl.tool.ConstantUtil.STRENGTH_COST_DECREMENT;

import java.io.Serializable;

import wyf.ytl.tool.GameFormula;

public class MiningSkill extends Skill implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3559227829150917303L;
	
	public MiningSkill(){}

	public MiningSkill(int id, String name, int basicEarning, int skillType,
			Hero hero) {
		super(id, name, basicEarning, skillType, hero);
		this.strengthCost = 18;
	}
	@Override
	public int calculateResult() {
		if(hero.strength < strengthCost){//���Ӣ�۵���������ʹ�ñ��μ���
			return -1;
		}
		else{//����Ӣ������
			int result = GameFormula.getSkillEearning(proficiencyLevel, basicEarning);
			return result;
		}
	}

	@Override
	public void useSkill(int skillEarning) {
		hero.setTotalMoney(hero.getTotalMoney() + skillEarning);//Ӣ�۽�Ǯ����
		hero.setStrength(hero.getStrength() - strengthCost);//Ӣ����������
		tempProficiency += PROFICIENCY_INCREMENT;//Ӣ����ʱ����������
		if(tempProficiency == proficiencyToUpgrade && proficiencyLevel<SKILL_LEVEL_MAX){//����������������
			proficiencyLevel += 1;//�����ȵȼ���1
			tempProficiency = 0;//��ʱ����������
			strengthCost -= STRENGTH_COST_DECREMENT;
			proficiencyToUpgrade+=PROFICIENCY_UPGRADE_SPAN;//��һ��������������
		}
	}
	
}