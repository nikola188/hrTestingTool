/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Beans.Answers;
import Core.GenerateQuestion;
import java.awt.Component;
import java.awt.Font;
import java.awt.Label;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import util2.TestQuestion;
import util2.TimeRestriction;
import Beans.Question;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import javax.swing.JCheckBox;

/**
 *
 * @author nikola.panajotovic
 * @author nikola.bijelic
 */
public class QuestionsPage extends javax.swing.JPanel {
    
    private List<TestQuestion> questions;
    private static int MINUTES = 60;
    private int candidateId;
    private int numberOfQuestions;
    private int testDuration;
    private List<JCheckBox> candidateAnswers;
    
    private JFrame root;

    private TimeRestriction restriction;
    /**
     * Creates new form QuestionsPage
     */
    public QuestionsPage(int numberOfQuestions, int testDuration, int candidateId) throws Exception {
        candidateAnswers = new ArrayList<>();
        this.numberOfQuestions = numberOfQuestions;
        this.testDuration = testDuration * MINUTES;
        this.candidateId = candidateId;
        initComponents();
        TimeRestriction.TESTDURATION = this.testDuration;
        restriction = new TimeRestriction(timeBar);
        initQuestionPanel(this.candidateId, this.numberOfQuestions);
        restriction.startTime();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        endBtn = new javax.swing.JButton();
        timeBar = new javax.swing.JProgressBar();
        timeLabel = new javax.swing.JLabel();
        tabPanelQuestions = new javax.swing.JTabbedPane();

        endBtn.setText("End Test");
        endBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                endBtnActionPerformed(evt);
            }
        });

        timeBar.setMaximum(30);
        timeBar.setStringPainted(true);

        timeLabel.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        timeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        timeLabel.setText("Remaining Time");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tabPanelQuestions)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(endBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(timeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(timeBar, javax.swing.GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabPanelQuestions, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(timeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(timeBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(endBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void endBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_endBtnActionPerformed
        for(JCheckBox box : candidateAnswers){
            if(box.isSelected()){
                System.out.println(box.getText());
            }
        }
    }//GEN-LAST:event_endBtnActionPerformed

    public void setParent(JFrame frame){
        root = frame;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton endBtn;
    private javax.swing.JTabbedPane tabPanelQuestions;
    private javax.swing.JProgressBar timeBar;
    private javax.swing.JLabel timeLabel;
    // End of variables declaration//GEN-END:variables

    private void initQuestionPanel(int candidateId, int numberOfQuestions) throws Exception {
        GenerateQuestion.getQuestions(candidateId, numberOfQuestions);
        questions = GenerateQuestion.getList();
        int numQuestions = questions.size();
        for(int i = 0; i < numQuestions; i++){
            JPanel panel= new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
            
            
            // initialize question text
            JLabel label= new JLabel();
            Font labelFont = label.getFont();
            label.setText(questions.get(i).getQuestion().getText());
            label.setFont(label.getFont().deriveFont(36.0f));
            label.setAlignmentX(Component.CENTER_ALIGNMENT);
            panel.add(label);
            
            
            // initialize answers
            Question q = questions.get(i).getQuestion();
            Collection<Answers> l = q.getAnswersCollection();
            
            Iterator iter = l.iterator();
            
            while(iter.hasNext()){
                JCheckBox checkBox = new JCheckBox();
                candidateAnswers.add(checkBox);
                Answers a = (Answers) iter.next();
                String answer = a.getText();
                checkBox.setText(answer);
                panel.add(checkBox);
            }
            tabPanelQuestions.addTab("Question " + (i + 1), panel);
        }
    }

}
