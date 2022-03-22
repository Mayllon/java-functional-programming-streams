package baumer.one.stream.example.validation;

import baumer.one.stream.bean.CloseApproachData;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;

import static java.util.Collections.emptySet;

public interface CloseApproachDataValidation extends Function<CloseApproachData, Set<Rules>> {

    CloseApproachDataValidation empty = $ -> emptySet();

    CloseApproachDataValidation closeApproachDateAfter2000 = rule(CloseApproachDataTrigger.isCloseApproachDateAfter2000, Rules.isCloseApproachDateAfter2000);
    CloseApproachDataValidation closeApproachDateBefore1950 = rule(CloseApproachDataTrigger.isCloseApproachDateBefore1950, Rules.isCloseApproachDateBefore1950);
    CloseApproachDataValidation moonOrbitingBody = rule(CloseApproachDataTrigger.isMoonOrbitingBody, Rules.isMoonOrbitingBody);

    static CloseApproachDataValidation rule(final Predicate<CloseApproachData> predicate, final Rules rule) {
        return user -> predicate.test(user) ? Collections.singleton(rule) : emptySet();
    }

    default CloseApproachDataValidation and(final CloseApproachDataValidation other) {
        return closeApproachData -> {
            final Set<Rules> left = this.apply(closeApproachData);
            final Set<Rules> right = other.apply(closeApproachData);

            final Set<Rules> merged = new HashSet<>(left);
            merged.addAll(right);

            return merged;
        };
    }
}
