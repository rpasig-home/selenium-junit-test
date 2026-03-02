import express from "express";

const app = express();
const port = Number(process.env.PORT ?? 3000);

app.get("/healthz", (_req, res) => res.status(200).json({ ok: true }));

app.get("/", (_req, res) => {
  res.type("html").send(`
<!doctype html>
<html>
<head>
  <meta charset="utf-8" />
  <title>Mock Trading UI</title>
</head>
<body>
  <h1 id="title">Mock Trading UI</h1>

  <label>Symbol <input id="symbol" value="NVDA" /></label>
  <label>Qty <input id="qty" type="number" value="3" /></label>
  <button id="place">Place Order</button>

  <div id="result" style="margin-top: 12px;"></div>

  <script>
    const btn = document.getElementById('place');
    btn.addEventListener('click', () => {
      const symbol = document.getElementById('symbol').value;
      const qty = document.getElementById('qty').value;
      document.getElementById('result').textContent = 'Placed order: ' + symbol + ' x ' + qty;
    });
  </script>
</body>
</html>
  `);
});

app.listen(port, () => console.log("mock-web listening on :" + port));
