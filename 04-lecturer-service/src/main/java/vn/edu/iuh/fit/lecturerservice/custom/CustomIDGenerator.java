package vn.edu.iuh.fit.lecturerservice.custom;

import lombok.AllArgsConstructor;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;


import java.io.Serializable;

public class CustomIDGenerator implements IdentifierGenerator {
    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
//        HelpMain helpMain = new HelpMain();
        String giangVienID = "GV" + (int) (Math.random() * 99999999);

//        if (helpMain.checkId(giangVienID)) {
//            return generate(session, object);
//        }
        return giangVienID;
    }
}


