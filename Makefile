# Runs full Selenium + Allure stack
test:
	# Clean previous containers and volumes
	docker compose down -v

	# Start infrastructure (app, selenium, report)
	docker compose up -d web selenium report

	# Run tests and remove container after
	docker compose run --rm tests