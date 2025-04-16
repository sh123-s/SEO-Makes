// Tab Switching Logic
const tabBtns = document.querySelectorAll(".tab-btn");
const tabContents = document.querySelectorAll(".tool-content");

tabBtns.forEach(btn => {
    btn.addEventListener("click", () => {
        // Remove active class from all buttons/contents
        tabBtns.forEach(btn => btn.classList.remove("active"));
        tabContents.forEach(content => content.classList.remove("active"));

        // Add active class to clicked button and corresponding content
        btn.classList.add("active");
        const tabId = btn.getAttribute("data-tab");
        document.getElementById(tabId).classList.add("active");
    });
});

// Tool 1: AI Meta Generator
function generateMeta() {
    const input = document.getElementById("meta-input").value;
    if (!input.trim()) {
        alert("Please enter some content!");
        return;
    }

    const title = input.split(" ").slice(0, 8).join(" "); // Simulate AI title
    const description = input.split(" ").slice(0, 25).join(" "); // Simulate AI description

    const result = `
        <strong>Title:</strong> ${title} <br>
        <strong>Meta Description:</strong> ${description} <br>
        <strong>OG Tags:</strong> 
        &lt;meta property="og:title" content="${title}"&gt; <br>
        &lt;meta property="og:description" content="${description}"&gt;
    `;

    document.getElementById("meta-result").innerHTML = result;
}

// Tool 2: Review Response Generator
function generateResponse() {
    const review = document.getElementById("review-input").value;
    if (!review.trim()) {
        alert("Please paste a review!");
        return;
    }

    const responses = [
        "Thanks for your feedback! We’re glad you enjoyed your experience.",
        "We appreciate your review and will work on improving.",
        "Thank you for your support! We hope to serve you again soon."
    ];

    const randomResponse = responses[Math.floor(Math.random() * responses.length)];
    document.getElementById("review-result").textContent = randomResponse;
}

// Tool 3: JS SEO Tester (Simulated)
function testJS() {
    const url = document.getElementById("js-url").value;
    if (!url.trim()) {
        alert("Please enter a URL!");
        return;
    }

    document.getElementById("js-result").textContent = 
        `Testing JavaScript rendering for: ${url} \n\nResult: ✅ Googlebot can render JS on this page.`;
}

// Copy to Clipboard Function
function copyResult(elementId) {
    const result = document.getElementById(elementId);
    const range = document.createRange();
    range.selectNode(result);
    window.getSelection().removeAllRanges();
    window.getSelection().addRange(range);
    document.execCommand("copy");
    alert("Copied to clipboard!");
}