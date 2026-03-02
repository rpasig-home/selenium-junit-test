FROM node:20-alpine
WORKDIR /app

COPY package.json ./
RUN npm i --omit=dev

COPY server.js ./
ENV PORT=3000
EXPOSE 3000

# ✅ Run node directly to avoid npm SIGTERM noise
CMD ["node", "server.js"]