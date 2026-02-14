const BASE_URL = "http://localhost:8080/api/resume";

// Resume Analyzer
function analyzeResume() {
    const fileInput = document.getElementById("resumeFile");
    const result = document.getElementById("result");

    if (!fileInput.files.length) {
        alert("Please upload a resume");
        return;
    }

    const formData = new FormData();
    formData.append("file", fileInput.files[0]);

    result.innerHTML = `<p class="placeholder">Analyzing resume...</p>`;

    fetch(`${BASE_URL}/analyzer`, {
        method: "POST",
        body: formData
    })
    .then(res => res.json())
    .then(data => {
        // Build dashboard card
        let html = `
            <div class="dashboard-card">
                <h3>Skills</h3>
                <div class="tags">
                    ${data.skills.map(skill => `<span class="tag matched">${skill}</span>`).join('')}
                </div>
            </div>
            <div class="dashboard-card">
                <h3>Experience</h3>
                <p>${data.experience}</p>
            </div>
            <div class="dashboard-card">
                <h3>Summary</h3>
                <p>${data.summary || "No summary provided"}</p>
            </div>
        `;
        result.innerHTML = html;
    })
    .catch(err => {
        result.innerHTML = `<p class="placeholder">Error analyzing resume</p>`;
        console.error(err);
    });
}

// ATS Checker
function checkATS() {
    const fileInput = document.getElementById("atsResumeFile");
    const jobDesc = document.getElementById("jobDescription").value;
    const result = document.getElementById("atsResult");

    if (!fileInput.files.length || !jobDesc) {
        alert("Please upload resume and enter job description");
        return;
    }

    const formData = new FormData();
    formData.append("file", fileInput.files[0]);
    formData.append("jobDescription", jobDesc);

    result.innerHTML = `<p class="placeholder">Checking ATS score...</p>`;

    fetch(`${BASE_URL}/ats-check`, {
        method: "POST",
        body: formData
    })
    .then(res => res.json())
    .then(data => {
        // Animated progress bar
        const score = data.atsScore || 0;
        let html = `
            <div class="progress-container">
                <div class="progress-bar" style="width: 0%;">0%</div>
            </div>
            <div class="tags-section">
                <h4>Matched Keywords</h4>
                <div class="tags">
                    ${data.matchedKeywords.map(k => `<span class="tag matched">${k}</span>`).join('')}
                </div>
                <h4>Missing Keywords</h4>
                <div class="tags">
                    ${data.missingKeywords.map(k => `<span class="tag missing">${k}</span>`).join('')}
                </div>
            </div>
        `;
        result.innerHTML = html;

        // Animate progress bar
        const progressBar = result.querySelector(".progress-bar");
        let width = 0;
        const interval = setInterval(() => {
            if (width >= score) clearInterval(interval);
            else {
                width++;
                progressBar.style.width = width + "%";
                progressBar.textContent = width + "%";
            }
        }, 15);
    })
    .catch(err => {
        result.innerHTML = `<p class="placeholder">Error checking ATS score</p>`;
        console.error(err);
    });
}
