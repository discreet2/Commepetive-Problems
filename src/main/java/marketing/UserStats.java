package marketing;

import java.util.Optional;

public class UserStats {
    private Long visitCount;

    public UserStats(Long visitCount) {
        this.visitCount = visitCount;
    }

    public Optional<Long> getVisitCount() {
        return Optional.of(this.visitCount);
    }
}
