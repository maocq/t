import Config

config :distributed_performance_analyzer,
  url: "http://_IP_:8080/api/case-one?latency=100",
  request: %{
    method: "GET",
    headers: [],
    body: ""
  },
  execution: %{
    steps: 20,
    increment: 50,
    duration: 500,
    constant_load: false,
    dataset: :none,
    separator: ","
  },
  distributed: :none

config :logger,
  level: :warn
