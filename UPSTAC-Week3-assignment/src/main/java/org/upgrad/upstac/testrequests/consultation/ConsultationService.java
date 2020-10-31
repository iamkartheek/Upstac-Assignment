package org.upgrad.upstac.testrequests.consultation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.upgrad.upstac.config.security.UserLoggedInService;
import org.upgrad.upstac.testrequests.TestRequest;
import org.upgrad.upstac.testrequests.lab.LabResult;
import org.upgrad.upstac.users.User;

import javax.transaction.Transactional;
import java.time.LocalDate;

@Service
@Validated
public class ConsultationService {

    @Autowired
    private ConsultationRepository consultationRepository;

    @Autowired
    private UserLoggedInService userLoggedInService;

    private static Logger logger = LoggerFactory.getLogger(ConsultationService.class);


    @Transactional
    public Consultation assignForConsultation( TestRequest testRequest, User doctor) {
        //Implement this method to assign the consultation service
        // create object of Consultation class and use the setter methods to set doctor and testRequest details
        // make use of save() method of consultationRepository to return the Consultation object
        Consultation consultation = new Consultation();
        consultation.setRequest(testRequest);
        consultation.setDoctor(doctor);
        consultationRepository.save(consultation);
        return consultation;

    }

    public Consultation updateConsultation(TestRequest testRequest , CreateConsultationRequest createConsultationRequest) {
        //Implement this method to update the consultation
        // create an object of Consultation and make use of setters to set Suggestion, Comments, and UpdatedOn values
        // make use of save() method of
        // to return the Consultation object
        Consultation consultation = testRequest.getConsultation();
        consultation.setComments(createConsultationRequest.getComments());
        consultation.setSuggestion(createConsultationRequest.getSuggestion());
        consultation.setUpdatedOn(LocalDate.now());
        consultationRepository.save(consultation);
        return consultation;
    }


}
