import com.typesafe.config.Config
import configs.{ GlobalConfig, RabbitMQConfig }
import utils.LogSupport

abstract class Runtime {
  val globalConfig: GlobalConfig
}

object Runtime extends LogSupport {

  def apply(config: Config): Runtime =
    new Runtime {
      override val globalConfig: GlobalConfig = GlobalConfig(config.getString("value1"), config.getString("value2"))
    }

  def execute(runtime: Runtime): Unit = {
    logger.info("Starting Runtime")
    logger.info(s"Configs: ${runtime.globalConfig}")
  }

}
