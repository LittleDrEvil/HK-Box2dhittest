/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package handlers;

import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.Manifold;
import entities.BoxBody;
import entities.PlayerBody;

/**
 *
 * @author karnh7634
 */
public class ContListener implements ContactListener{

    @Override
    public void beginContact(Contact contact) {
        Fixture fa = contact.getFixtureA();
        Fixture fb = contact.getFixtureB();
        
        if(fa == null || fb ==null) return;
        if(fa.getUserData() == null || fb.getUserData() == null) return;
        if(isContact(fa,fb)){
            System.out.println(fa.getUserData().toString());
            if(fa.getUserData().toString().contains("PlayerBody") && fb.getUserData().toString().contains("BoxBody")){
                PlayerBody tba = (PlayerBody) fa.getUserData();
                BoxBody tbb = (BoxBody) fb.getUserData();
                tba.hit();
                tbb.hit();
            }
            if(fa.getUserData().toString().contains("BoxBody") && fb.getUserData().toString().contains("BoxBody")){
                BoxBody tba = (BoxBody) fa.getUserData();
                BoxBody tbb = (BoxBody) fb.getUserData();
                tba.hit();
                tbb.hit();
            }
        }
    }

    @Override
    public void endContact(Contact contact) {
        Fixture fa = contact.getFixtureA();
        Fixture fb = contact.getFixtureB();
        
        if(fa == null || fb ==null) return;
        if(fa.getUserData() == null || fb.getUserData() == null) return;
    }

    @Override
    public void preSolve(Contact contact, Manifold oldManifold) {
    }

    @Override
    public void postSolve(Contact contact, ContactImpulse impulse) {
    }
    
    private boolean isContact(Fixture a, Fixture b){
                return true;
            }
//        return(a.getUserData() instanceof BoxBody && b.getUserData() instanceof BoxBody);

    
}
