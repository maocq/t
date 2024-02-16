import Config

config :distributed_performance_analyzer,
  url: "http://_IP_:8080/api/case-two?number=50000",
  request: %{
    method: "GET",
    headers: [],
    body: ""
  },
  execution: %{
    steps: 20,
    increment: 30,
    duration: 10000,
    constant_load: false,
    dataset: :none,
    separator: ","
  },
  distributed: :none,
  jmeter_report: false

config :logger,
  level: :warn
