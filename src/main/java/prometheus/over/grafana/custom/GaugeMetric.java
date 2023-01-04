package prometheus.over.grafana.custom;

import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.MeterRegistry;
import java.util.function.Supplier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GaugeMetric {

  public GaugeMetric(MeterRegistry registry) {

    Gauge.builder("gauge.metric",gauge()).
        tag("version","v1").
        description("gauge").
        register(registry);

  }

  @GetMapping("/gauge")
  public Supplier<Number> gauge() {
    return () -> 5;
  }

}
