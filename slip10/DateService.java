package slip10;

import org.springframework.stereotype.Service;
import java.util.Date;

@Service
public class DateService {
    public Date getCurrentDate() {
        return new Date();
    }
}