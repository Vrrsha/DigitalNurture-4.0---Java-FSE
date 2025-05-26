// script.js

// Confirm before leaving the page
function warnBeforeUnload() {
  return "Are you sure you want to leave this page? Unsaved changes may be lost.";
}

// Enlarge image on double click
function enlargeImage(img) {
  img.classList.toggle("enlarged");
}

// Validate phone number format
function validatePhone(input) {
  const pattern = /^[6-9]\d{9}$/;
  if (!pattern.test(input.value)) {
    alert("Please enter a valid 10-digit phone number starting with 6-9.");
    input.focus();
  }
}

// Show fee based on selected event type
function showFee(select) {
  const fees = {
    music: "₹500",
    tech: "₹300",
    food: "₹200"
  };
  const feeText = fees[select.value] || "";
  document.getElementById("feeDisplay").innerText = feeText ? `Fee: ${feeText}` : "";
}

// Character counter for message textarea
function countCharacters(textarea) {
  const count = textarea.value.length;
  document.getElementById("charCount").innerText = `Characters: ${count}`;
}

// Submit form with confirmation
function submitForm(event) {
  event.preventDefault();
  confirmSubmit();
}

function confirmSubmit() {
  const name = document.getElementById("name").value.trim();
  const email = document.getElementById("email").value.trim();
  const phone = document.getElementById("phone").value.trim();
  const date = document.getElementById("date").value;
  const eventType = document.getElementById("eventType").value;

  if (!name || !email || !phone || !date || !eventType) {
    alert("Please fill in all required fields.");
    return;
  }

  document.getElementById("confirmationMsg").innerText = `Thank you, ${name}. Your registration for the ${eventType} event has been submitted.`;
  document.getElementById("eventForm").reset();
  document.getElementById("charCount").innerText = "Characters: 0";
  document.getElementById("feeDisplay").innerText = "";
}

// Save selected event type to localStorage
function savePreference() {
  const eventType = document.getElementById("eventType").value;
  if (eventType) {
    localStorage.setItem("preferredEventType", eventType);
    alert("Preference saved.");
  } else {
    alert("Please select an event type first.");
  }
}

// Clear saved preferences from localStorage
function clearPreferences() {
  localStorage.removeItem("preferredEventType");
  alert("Preferences cleared.");
}

// Load saved preference when page loads
window.onload = function () {
  const savedEvent = localStorage.getItem("preferredEventType");
  if (savedEvent) {
    document.getElementById("eventType").value = savedEvent;
    showFee(document.getElementById("eventType"));
  }
};

// Geolocation for finding nearby events
function getLocation() {
  const output = document.getElementById("locationOutput");
  if (!navigator.geolocation) {
    output.innerText = "Geolocation is not supported by this browser.";
    return;
  }
  output.innerText = "Fetching location...";
  navigator.geolocation.getCurrentPosition(
    (position) => {
      output.innerText = `Latitude: ${position.coords.latitude}, Longitude: ${position.coords.longitude}`;
    },
    (error) => {
      output.innerText = "Unable to retrieve location.";
    }
  );
}

// Show video ready status
function videoReady() {
  document.getElementById("videoStatus").innerText = "Video is ready to play!";
}
