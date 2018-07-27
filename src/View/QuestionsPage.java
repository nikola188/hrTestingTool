/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Beans.Answers;
import Beans.Question;
import Core.GenerateQuestion;
import java.awt.Component;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import util2.TestQuestion;
import util2.TimeRestriction;

/**
 *
 * @author nikola.panajotovic
 * @author nikola.bijelic
 * @author stefan.savic
 */
public class QuestionsPage extends javax.swing.JPanel {
    
    private static int QUESTION_NUMBER = 0; 
    
    private List<JCheckBox> offeredAnswers;
    private List<TestQuestion> questions;
    private List<QuestionPanel> panels;
    private static int MINUTES = 60;
    private int candidateId;
    private int numberOfQuestions;
    private int testDuration;
    private double finalResult;
    
    private JFrame root;

    private TimeRestriction restriction;
    /**
     * Creates new form QuestionsPage
     */
    public QuestionsPage(int numberOfQuestions, int testDuration, int candidateId) throws Exception {
        panels = new ArrayList<>();
        offeredAnswers = new ArrayList<>();
        this.numberOfQuestions = numberOfQuestions;
        this.testDuration = testDuration * MINUTES;
        this.candidateId = candidateId;
        initComponents();
        TimeRestriction.TESTDURATION = this.testDuration;
        restriction = new TimeRestriction(timeBar);
        restriction.startTime();
        initQuestionPanels();
        utilPanel.setVisible(true);
        finalResult = 0;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        endBtn = new javax.swing.JButton();
        timeBar = new javax.swing.JProgressBar();
        timeLabel = new javax.swing.JLabel();
        previousBtn = new javax.swing.JButton();
        nextBtn = new javax.swing.JButton();
        utilPanel = new javax.swing.JPanel();

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

        previousBtn.setText("Previous");
        previousBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previousBtnActionPerformed(evt);
            }
        });

        nextBtn.setText("Next");
        nextBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextBtnActionPerformed(evt);
            }
        });

        utilPanel.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(utilPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(endBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(timeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(timeBar, javax.swing.GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(previousBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(nextBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(utilPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(previousBtn)
                    .addComponent(nextBtn))
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
        restriction.stopTime();
        for(int i = 0; i < questions.size(); i++){
            Question q = questions.get(i).getQuestion();
            int points = q.getPoints();
            int correctAnswers = 0;
            Collection<Answers> answers = q.getAnswersCollection();
            Iterator iterator = answers.iterator();
            while(iterator.hasNext()){
                Answers a = (Answers)iterator.next();
                if(a.getIsCorrect()){
                    correctAnswers++;
                }
            }
            double pointsPerCorrect = points / correctAnswers;
            
        }
    }//GEN-LAST:event_endBtnActionPerformed

    private void previousBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previousBtnActionPerformed
        if(QUESTION_NUMBER > 0){
            JPanel panel = panels.get(QUESTION_NUMBER);
            panel.setVisible(false);
            utilPanel.remove(utilPanel.getComponent(0));
            QUESTION_NUMBER--;
            panel = panels.get(QUESTION_NUMBER);
            panel.setVisible(true);
            utilPanel.add(panel);
        }
    }//GEN-LAST:event_previousBtnActionPerformed

    private void nextBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextBtnActionPerformed
        if(QUESTION_NUMBER < questions.size() - 1){
            JPanel panel = panels.get(QUESTION_NUMBER);
            panel.setVisible(false);
            utilPanel.remove(utilPanel.getComponent(0));
            QUESTION_NUMBER++;
            panel = panels.get(QUESTION_NUMBER);
            panel.setVisible(true);
            utilPanel.add(panel);
        }
    }//GEN-LAST:event_nextBtnActionPerformed

    public void setParent(JFrame frame){
        root = frame;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton endBtn;
    private javax.swing.JButton nextBtn;
    private javax.swing.JButton previousBtn;
    private javax.swing.JProgressBar timeBar;
    private javax.swing.JLabel timeLabel;
    private javax.swing.JPanel utilPanel;
    // End of variables declaration//GEN-END:variables


    private void initQuestionPanels() throws Exception {
        GenerateQuestion.getQuestions(candidateId, numberOfQuestions);
        questions = GenerateQuestion.getList();
        System.out.println(questions.size());
        for(int i = 0; i < questions.size(); i++){
            QuestionPanel panel = new QuestionPanel();
            JLabel question = new JLabel(questions.get(i).getQuestion().getText());
            question.setHorizontalAlignment(JLabel.CENTER);
            panel.add(question);
            panel.setBounds(utilPanel.getBounds());
            
            // answers
            
            Question q = questions.get(i).getQuestion();
            Collection<Answers> answers = q.getAnswersCollection();
            Iterator iterator = answers.iterator();
            while(iterator.hasNext()){
                Answers a = (Answers)iterator.next();
                JCheckBox box = new JCheckBox();
                box.setText(a.getText());
                box.setActionCommand(String.valueOf(a.getId()));
                panel.add(box);
                offeredAnswers.add(box);
            }
            
            panels.add(panel);
        }
        JPanel jp = panels.get(QUESTION_NUMBER);
        jp.setVisible(true);
        utilPanel.add(jp);
    }

    public List<TestQuestion> getQuestions() {
        return questions;
    }

    public JFrame getRoot() {
        return root;
    }

}
