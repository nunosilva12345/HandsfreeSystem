/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backendBeans;

import connectionDB.DataDAO;
import connectionDB.SessionUtils;
import entities.Profile;
import entities.Voice;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Carolina
 */

@ManagedBean(name = "voicesbean")
@ViewScoped
public class VoicesBean {

    private HttpSession session;

    private List<Voice> voices;
    private List<Voice> voicesUnsed;
    private List<Voice> allVoices;
    private List<Voice> allVoices2;
    
    
    private Voice selectedVoice;
    private Voice newVoice;

    @PostConstruct
    public void init() {
        session = SessionUtils.getSession();
        voices = addVoices();
        allVoices = addAllVoices();
        allVoices2 = addAllVoices2();
        voicesUnsed = new ArrayList<Voice>();
    }

    public Voice getNewVoice() {
        return newVoice;
    }

    public void setNewVoice(Voice newVoice) {
        this.newVoice = newVoice;
    }
    
    public void setAllVoices(List<Voice> allVoices) {
        this.allVoices = allVoices;
    }

    public List<Voice> getAllVoices() {
        return allVoices;
    }
    
    public List<Voice> getVoicesUnsed() {
        return voicesUnsed;
    }

    public void setVoicesUnsed(List<Voice> voicesUnsed) {
        this.voicesUnsed = voicesUnsed;
    }
    
    public List<Voice> getVoices() {
        return voices;
    }

    public void setVoices(List<Voice> voices) {
        this.voices = voices;
    }

    public Voice getSelectedVoice() {
        return selectedVoice;
    }

    public void setSelectedVoice(Voice selectedVoice) {
        this.selectedVoice = selectedVoice;
    }

    public List<Voice> getAllVoices2() {
        return allVoices2;
    }

    public void setAllVoices2(List<Voice> allVoices2) {
        this.allVoices2 = allVoices2;
    }
    
    
   
    public List<Voice> addVoices() {
        Profile selectedProfile = (Profile) session.getAttribute("profile");
        return DataDAO.voiceCommands(selectedProfile);
    }
    
    public List<Voice> addAllVoices() {
        return DataDAO.getAllVoices();
    }
    
    public List<Voice> addAllVoices2(){
        return DataDAO.getAllVoicesWithoutActions();
    }
    
    public List<Voice> addVoicesUnsed() {
        for(Voice v : allVoices2){
            if(!voices.contains(v))
                voicesUnsed.add(v);
        }
        return voicesUnsed;
    }
    
    
    public String updateVoiceCommands() throws ClassNotFoundException{
        System.out.println("SELECTED: " + selectedVoice.getAction() + "\nNEW:" +  newVoice);
        DataDAO.updateVoiceCommands(selectedVoice.getAction().getId(), selectedVoice.getId(), newVoice.getId());
        return "profiles_voice.xhtml";
    }

}
