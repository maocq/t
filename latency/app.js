const express = require('express')
const app = express()
const port = 8080

app.get('/:latency?', (req, res) => {
  setTimeout(() => res.json({id: "CC12345" + Math.floor(Math.random() * 9999), name: "Foo"}), req.params.latency || 0);
})

app.listen(port, () => {
  console.log(`Example app listening at http://localhost:${port}`)
})
