import Config

config :distributed_performance_analyzer,
  url: "http://_IP_:8080/api/case-three",
  request: %{
    method: "GET",
    headers: [],
    body: ""
  },
  execution: %{
    steps: 20,
    increment: 500,
    duration: 20000,
    constant_load: true,
    dataset: :none,
    separator: ","
  },
  distributed: :none,
  jmeter_report: false

config :logger,
  level: :warn
