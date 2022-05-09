package escapefromuniversity.model.enemy;

import escapefromuniversity.model.DynamicGameObject;

public interface Enemy extends DynamicGameObject{
	
	void maybeShoot();
	
	int getLife();
	
	void takeDamage(int damage);

}
