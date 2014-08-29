package wyf.ytl.entity;

import static wyf.ytl.tool.ConstantUtil.PROFICIENCY_INCREMENT;
import static wyf.ytl.tool.ConstantUtil.PROFICIENCY_UPGRADE_SPAN;
import static wyf.ytl.tool.ConstantUtil.SKILL_LEVEL_MAX;
import static wyf.ytl.tool.ConstantUtil.STRENGTH_COST_DECREMENT;

import java.io.Serializable;

import wyf.ytl.tool.GameFormula;

public class FishingSkill extends Skill implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8340082496101415066L;
	
	public FishingSkill(){}

	public FishingSkill(int id, String name, int basicEarning, int skillType,
			Hero hero) {
		super(id, name, basicEarning, skillType, hero);
		this.strengthCost = 14;
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
			proficiencyToUpgrade+=PROFICIENCY_UPGRADE_SPAN;//��һ��������������
			strengthCost -= STRENGTH_COST_DECREMENT;//���ĵ�����ֵ����
		}
	}
}